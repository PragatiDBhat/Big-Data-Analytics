package org.bdaproject.Mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

public class q5map extends Mapper<Object, Text, Text, IntWritable> {
    private final static IntWritable one = new IntWritable(1);

    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        // Split the line into fields using comma as the delimiter
        String[] fields = value.toString().split(",");

        // Check if there are enough fields to access the "Ethnic Appearance Code" and "Outcome" columns (indexes 12 and 8)
        if (fields.length > 12) {
            String ethnicAppearanceCode = fields[12].trim(); // Column index 12: Ethnic Appearance Code
            String outcome = fields[8].trim(); // Column index 8: Outcome

            // Skip lines where ethnic appearance code or outcome is empty
            if (!ethnicAppearanceCode.isEmpty() && !outcome.isEmpty()) {
                String outputKey = ethnicAppearanceCode + "-" + outcome; // Combine both to create a unique key
                context.write(new Text(outputKey), one);
            }
        }
    }
}
