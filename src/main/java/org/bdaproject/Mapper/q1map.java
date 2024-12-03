package org.bdaproject.Mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class q1map extends Mapper<Object, Text, Text, IntWritable> {
    private final static IntWritable one = new IntWritable(1);

    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        String[] fields = value.toString().split(",");

        // Ensure sufficient fields
        if (fields.length > 2) {
            String borough = fields[2].trim(); // Borough from input
            context.write(new Text(borough), one); // Emit <borough, 1>
        }
    }
}
