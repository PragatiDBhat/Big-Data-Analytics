package org.bdaproject.Mapper;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class q10map extends Mapper<Object, Text, Text, Text> {
    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        // Split the line into fields
        String[] fields = value.toString().split(",");

        // Ensure there are enough fields to access MPS Area and Apparent Age
        if (fields.length > 10) {
            String mpsArea = fields[1].trim(); // Column 1: MPS Area
            String apparentAge = fields[10].trim(); // Column 10: Apparent Age

            // Check if both MPS Area and Apparent Age are non-empty and valid
            if (!mpsArea.isEmpty() && !apparentAge.isEmpty()) {
                try {
                    Double.parseDouble(apparentAge); // Validate Apparent Age as a numeric value
                    context.write(new Text(mpsArea), new Text(apparentAge + ",1"));
                } catch (NumberFormatException e) {
                    // Ignore invalid apparent age
                }
            }
        }
    }
}
