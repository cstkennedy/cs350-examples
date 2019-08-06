CHECKSTYLE_JAR=/home/tkennedy/Courses/bin/checkstyle-8.8-all.jar


for i in Java1 Java2 Java3 OfficeHoursExamples JUnit; do
    java -jar ${CHECKSTYLE_JAR} -c checkstyle.xml $i* 2>&1 | sort | sed "s|`pwd`/||g" > build/$i-style-check-java.txt
done
