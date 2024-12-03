package org.bdaproject.Reducer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;

public class q7reduce extends Reducer<Text, IntWritable, Text, IntWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int sum = 0;

        // Sum the values for each key (gender and MPS Area combination)
        for (IntWritable value : values) {
            sum += value.get();
        }

        // Emit the combined key (gender and MPS Area) and the total count of stops
        context.write(key, new IntWritable(sum));
    }
}
