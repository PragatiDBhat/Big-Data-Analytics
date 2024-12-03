package org.bdaproject.Mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

public class q3map extends Mapper<Object, Text, Text, IntWritable> {
    private final static IntWritable one = new IntWritable(1);

    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        // Split the line into fields
        String[] fields = value.toString().split(",");

        // Check if there are enough fields to access the "Apparent Age" column
        if (fields.length > 10) {
            String apparentAge = fields[10].trim(); // Column index 10: Apparent Age

            // Skip lines where the "Apparent Age" is non-numeric or empty
            if (!apparentAge.isEmpty() && isNumeric(apparentAge)) {
                context.write(new Text(apparentAge), one);
            }
        }
    }

    // Helper method to check if a string is numeric
    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str); // Try to parse as a double
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
