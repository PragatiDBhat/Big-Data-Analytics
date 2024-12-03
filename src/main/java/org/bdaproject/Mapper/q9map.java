package org.bdaproject.Mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

public class q9map extends Mapper<Object, Text, Text, IntWritable> {
    private final static IntWritable one = new IntWritable(1);

    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        // Split the input line into fields
        String[] fields = value.toString().split(",");

        // Ensure there are enough fields to access MPS Area and Ethnic Appearance Code
        if (fields.length > 12) {
            String mpsArea = fields[1].trim(); // Column 1: MPS Area
            String ethnicCode = fields[12].trim(); // Column 12: Ethnic Appearance Code

            // Check if MPS Area and Ethnic Appearance Code are non-empty
            if (!mpsArea.isEmpty() && !ethnicCode.isEmpty()) {
                context.write(new Text(mpsArea + "," + ethnicCode), one);
            }
        }
    }
}
