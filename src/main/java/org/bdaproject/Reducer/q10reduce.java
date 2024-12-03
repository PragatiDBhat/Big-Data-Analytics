package org.bdaproject.Reducer;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class q10reduce extends Reducer<Text, Text, Text, Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        double totalAge = 0.0;
        int count = 0;

        // Sum up the ages and count the occurrences
        for (Text value : values) {
            String[] parts = value.toString().split(",");
            totalAge += Double.parseDouble(parts[0]); // Apparent Age
            count += Integer.parseInt(parts[1]); // Count
        }

        // Calculate the average
        double averageAge = totalAge / count;

        // Write the result (key: MPS Area, value: Average Apparent Age)
        context.write(key, new Text(String.format("%.2f", averageAge)));
    }
}
