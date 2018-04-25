package edu.odu.cs.cs350.examples.weka;

import java.util.Set;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import weka.classifiers.Classifier;
import weka.classifiers.functions.SMO;
import weka.classifiers.functions.supportVector.RBFKernel;

import weka.core.FastVector;
import weka.core.Instances;
import weka.core.Instance;
import weka.core.DenseInstance;
import weka.core.Attribute;
import weka.core.converters.ConverterUtils.DataSource;


/**
 * A class roster listing all students enrolled
 * in a course.
 */
public class BasicWeka1 {
    /**
     * A simple main function
     *
     * @param args command line arguments
     */
    public static void main(String[] args)
        throws java.lang.Exception
    {
        String[] outlookNames = {"sunny", "overcast", "rainy"};
        Attribute outlook = new Attribute("outlook", Arrays.asList(outlookNames)); 

        Attribute temperature = new Attribute("temperature"); // numeric
        Attribute humidity = new Attribute("humidity"); // numeric

        String[] windyNames = {"TRUE", "FALSE"};
        Attribute windy = new Attribute("windy", Arrays.asList(windyNames)); 

        String[] playNames = {"yes", "no"};
        Attribute play = new Attribute("play", Arrays.asList(playNames)); 

        //FastVector attrInfo = new FastVector();
        ArrayList<Attribute> attrInfo = new ArrayList<Attribute>();
        attrInfo.add(outlook);
        attrInfo.add(temperature);
        attrInfo.add(humidity);
        attrInfo.add(windy);
        attrInfo.add(play);

        final int numberOfAttributes = attrInfo.size();

        String[] trainingData = {
            "sunny,85,85,FALSE,no",
            "sunny,80,90,TRUE,no",
            "overcast,83,86,FALSE,yes",
            "rainy,70,96,FALSE,yes",
            "rainy,68,80,FALSE,yes",
            "rainy,65,70,TRUE,no",
            "overcast,64,65,TRUE,yes",
            "sunny,72,95,FALSE,no",
            "sunny,69,70,FALSE,yes",
            "rainy,75,80,FALSE,yes",
            "sunny,75,70,TRUE,yes",
            "overcast,72,90,TRUE,yes",
            "overcast,81,75,FALSE,yes",
            "rainy,71,91,TRUE,no"
        };

        Instances training = new Instances("TrainingData",
                                           attrInfo, 
                                           trainingData.length);

        training.setClass(play); // Which attribute holds the
                               // class/category that we want
                               // to predict?

        for (String sdata: trainingData) {
            String[] values = sdata.split(",");

            // Debugging output
            for (String str : values) {
                System.out.print(str + "|");
            }
            System.out.println();
            // End debugging

            double[] instanceValues = new double[numberOfAttributes];

            instanceValues[0] = training.attribute(0).indexOfValue(values[0]); // outlook
            instanceValues[1] = Double.parseDouble(values[1]); // temperature
            instanceValues[2] = Double.parseDouble(values[2]); // humidity
            instanceValues[3] = training.attribute(3).indexOfValue(values[3]); // windy
            instanceValues[4] = training.attribute(4).indexOfValue(values[4]); // play

            Instance instance = new DenseInstance(1.0, instanceValues);
            /*instance.setValue(0, "sunny"); // outlook
            instance.setValue(1, Double.parseDouble(values[1])); // temperature
            instance.setValue(2, Double.parseDouble(values[2])); // humidity
            instance.setValue(3, values[3]); // windy
            instance.setValue(4, values[4]); // play*/

            training.add(instance); // Add new instance to training data
        }


        // Build Classifier
        final double gamma = 0.01; // initial guess
        final double C = 1.0;      // initial guess
        String[] options = {"-N", "0", "-V", "-1"};

        // Create the classifier
        SMO svm = new SMO();         // new instance of classifier
        svm.setOptions(options);     // set the options
        svm.setKernel(new RBFKernel(training, 25007, gamma));
        svm.setC(C);

        // Train it
        svm.buildClassifier(training);
    }
}