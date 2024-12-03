package org.bdaproject.Mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

public class q8map extends Mapper<Object, Text, Text, IntWritable> {
    private final static IntWritable one = new IntWritable(1);

    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        // Split the input line into fields
        String[] fields = value.toString().split(",");

        // Ensure there are enough fields to access MPS Area and Subject
        if (fields.length > 7) {
            String mpsArea = fields[1].trim(); // Column 1: MPS Area
            String subject = fields[6].trim(); // Column 6: Subject

            // Check if MPS Area and Subject are non-empty
            if (!mpsArea.isEmpty() && !subject.isEmpty()) {
                context.write(new Text(mpsArea + "," + subject), one);
            }
        }
    }
}
