package org.bdaproject.Mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

public class q4map extends Mapper<Object, Text, Text, IntWritable> {
    private final static IntWritable one = new IntWritable(1);

    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        // Split the line into fields using comma as the delimiter
        String[] fields = value.toString().split(",");

        // Check if there are enough fields to access the "Gender" column (index 11)
        if (fields.length > 11) {
            String gender = fields[11].trim(); // Column index 11: Gender

            // Skip lines where gender is empty or not a valid value
            if (!gender.isEmpty()) {
                context.write(new Text(gender), one);
            }
        }
    }
}
