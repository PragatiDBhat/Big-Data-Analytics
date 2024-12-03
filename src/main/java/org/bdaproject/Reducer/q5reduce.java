package org.bdaproject.Reducer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;

public class q5reduce extends Reducer<Text, IntWritable, Text, IntWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int sum = 0;

        // Sum the values for each key (Ethnic Appearance Code - Outcome combination)
        for (IntWritable value : values) {
            sum += value.get();
        }

        // Emit the unique key (Ethnic Appearance Code - Outcome) and the total count
        context.write(key, new IntWritable(sum));
    }
}
