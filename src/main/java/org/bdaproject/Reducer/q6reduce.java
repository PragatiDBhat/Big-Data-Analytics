package org.bdaproject.Reducer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;

public class q6reduce extends Reducer<Text, IntWritable, Text, IntWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int sum = 0;

        // Sum the values for each key (MPS Area)
        for (IntWritable value : values) {
            sum += value.get();
        }

        // Emit the MPS Area and the total count of stops
        context.write(key, new IntWritable(sum));
    }
}
