package org.bdaproject.Mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

public class q6map extends Mapper<Object, Text, Text, IntWritable> {
    private final static IntWritable one = new IntWritable(1);

    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        // Split the line into fields using comma as the delimiter
        String[] fields = value.toString().split(",");

        // Check if there are enough fields to access the "MPS Area" column (index 1)
        if (fields.length > 1) {
            String mpsArea = fields[1].trim(); // Column index 1: MPS Area

            // Skip lines where MPS Area is empty
            if (!mpsArea.isEmpty()) {
                context.write(new Text(mpsArea), one);
            }
        }
    }
}
