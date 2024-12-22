package edu.odu.cs.cs350.unitTesting;

import java.util.List;

/**
 * A unit test tracker watches the mutators and accessor calls on a class under test
 * and reports covered pairs to a UnitTestMatrix.
 *
 * @author zeil
 */
public class UnitTestTracker {

  private UnitTestMatrix utm;
  private String lastMutatorName;
  private int lastMutatorLine;

  /**
   * Construct a tracker for an object.
   * @param classToTrack   the class to be watched
   * @param mutatorFunctionNames  names of non-constructor, non-static member
   *                              functions that modify the
   *                              state of the object
   * @param accessorFunctionNames names of non-static member functions that
   *                              examine but do not modify the
   *                              state of the object
   */
  public UnitTestTracker(Class<?> classToTrack,
                         List<String> mutatorFunctionNames,
                         List<String> accessorFunctionNames)
  {
    utm = UnitTestMatrix.get(classToTrack, mutatorFunctionNames, accessorFunctionNames);
    lastMutatorName = null;
  }


  /**
   * Indicate that a mutator call is in progress.
   */
  public void mutate()
  {
    StackTraceElement[] activationStack = Thread.currentThread().getStackTrace();
    // activationStack[0] should be this try-catch
    // activationStack[1] should be the mutate() call
    // activationStack[2] should be the method that called mutate
    StackTraceElement caller = activationStack[2];
    lastMutatorName = caller.getMethodName();
    lastMutatorLine = caller.getLineNumber();
  }

  /**
   * Indicate that an accessor call is in progress.
   */
  public void access()
  {
    StackTraceElement[] activationStack = Thread.currentThread().getStackTrace();
    // activationStack[0] should be this try-catch
    // activationStack[1] should be the mutate() call
    // activationStack[2] should be the method that called mutate
    StackTraceElement caller = activationStack[2];
    String accessorName = caller.getMethodName();
    int accessorLine = caller.getLineNumber();
    utm.covered(lastMutatorName,  lastMutatorLine, accessorName, accessorLine);
  }

  /**
   * Returns the last know mutator to have operated on this class.
   * @return mutator
   */
  public String getLastMutator()
  {
    return lastMutatorName;
  }


}
