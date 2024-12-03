package org.bdaproject.Reducer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class q1reduce extends Reducer<Text, IntWritable, Text, IntWritable> {
    private boolean headerPrinted = false;

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int sum = 0;

        // Sum up the counts for the same borough
        for (IntWritable value : values) {
            sum += value.get();
        }

        // Print the header only once at the beginning of the output
        if (!headerPrinted) {
            // Print the header in CSV format
            context.write(new Text("Borough,         Total Stops"), null); // Header row, use null for value
            headerPrinted = true;
        }

        // Emit the actual output as key-value pairs in CSV format
        context.write(new Text(key.toString() + ","), new IntWritable(sum)); // Correct CSV formatting
    }
}
