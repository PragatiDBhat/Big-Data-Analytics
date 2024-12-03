package org.bdaproject.Mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

public class q7map extends Mapper<Object, Text, Text, IntWritable> {
    private final static IntWritable one = new IntWritable(1);

    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        // Split the line into fields using comma as the delimiter
        String[] fields = value.toString().split(",");

        // Check if there are enough fields to access the "Gender" and "MPS Area" columns (indices 1 and 10)
        if (fields.length > 11) {
            String mpsArea = fields[1].trim(); // Column index 1: MPS Area
            String gender =  fields[11].trim(); // Column index 10: Gender

            // Skip lines where MPS Area or Gender is empty
            if (!mpsArea.isEmpty() && !gender.isEmpty()) {
                String compositeKey = gender + " - " + mpsArea;
                context.write(new Text(compositeKey), one);
            }
        }
    }
}
