package org.bdaproject.Reducer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;

public class q9reduce extends Reducer<Text, IntWritable, Text, IntWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int sum = 0;

        // Sum the values for each (MPS Area, Ethnic Appearance Code) key
        for (IntWritable value : values) {
            sum += value.get();
        }

        // Write the result (key: MPS Area, Ethnic Appearance Code, value: Count)
        context.write(key, new IntWritable(sum));
    }
}
