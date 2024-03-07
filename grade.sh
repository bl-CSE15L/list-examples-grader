CPATH='.;lib/hamcrest-core-1.3.jar;lib/junit-4.13.2.jar'

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone $1 student-submission
echo 'Finished cloning'

if [[ -f student-submission/ListExamples.java ]]
then
    echo "ListExamples.java found"
else
    echo "ListExamples.java not found!"
    exit 1
fi

cp -r lib grading-area
cp student-submission/ListExamples.java grading-area/
cp TestListExamples.java grading-area/

cd grading-area
javac -cp $CPATH *.java

if [[ $? -ne 0 ]] 
then 
    echo "Compile error!"
    exit 1
else    
    echo "Compiled successfully"
fi

java -cp $CPATH org.junit.runner.JUnitCore TestListExamples > junit-output.txt

lastLine=$(tail -n 2 junit-output.txt | head -n 1)
tests=$(echo $lastLine | awk -F'[, ]' '{print $3}')
failures=$(echo $lastLine | awk -F'[, ]' '{print $6}')

if [[ $tests =~ ^[0-9]+$ ]]; then
    successes=$((tests - failures))
    echo "Score: $successes / $tests"
else
    echo "All tests passed!"
fi