package edu.odu.cs.cs350.unitTesting;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.omg.SendingContext.RunTime;

/**
 * This class tracks Mutator-Accessor coverage for a given class during a
 * unit test execution.
 * It is intended to provide a single instance accumulating a summary report from an
 * arbitrary number of tracked objects of the target class.
 *
 * @author zeil
 *
 */
public class UnitTestMatrix {

  class TrackedMember {
    public String name;
    public int line;

    public TrackedMember(String name) {
      this.name = name;
      line = -1;
    }

    public TrackedMember(String name, int line) {
      this.name = name;
      this.line = line;
    }

    public String toString() {
      return name + ":" + line;
    }

  }

  private Class<?> targetClass;
  private ArrayList<TrackedMember> mutators;
  private ArrayList<TrackedMember> accessors;
  private boolean[][] isCovered;
  private int numCovered;

  private static ArrayList<UnitTestMatrix> matrices = new ArrayList<>();

  private static class ShutDownMgr {
    public ShutDownMgr() {
      Runtime.getRuntime().addShutdownHook(
          new Thread() {
            public void run() {
              for (UnitTestMatrix utm: matrices) {
                System.err.println(utm.toString());
              }
            }
          }
      );
    }
  }

  @SuppressWarnings("unused")
  private static ShutDownMgr shutdown = new ShutDownMgr();


  /**
   * Obtain a previously registered matrix for a class to be monitored.
   *
   * @param classToTrack   the class to be watched
   */
  public static UnitTestMatrix get(Class<?> classToTrack) {
    for (UnitTestMatrix utm: matrices) {
      if (utm.targetClass.equals(classToTrack)) {
        return utm;
      }
    }
    return null;
  }

  /**
   * Obtain a class on which coverage is to be monitored.
   *
   * @param classToTrack   the class to be watched
   * @param mutatorFunctionNames  names of non-constructor, non-static member
   *                              functions that modify the
   *                              state of the object
   * @param accessorFunctionNames names of non-static member functions that
   *                              examine but do not modify the
   *                              state of the object
   */
  public static UnitTestMatrix get(Class<?> classToTrack,
      List<String> mutatorFunctionNames,
      List<String> accessorFunctionNames) {
    for (UnitTestMatrix utm: matrices) {
      if (utm.targetClass.equals(classToTrack)) {
        return utm;
      }
    }
    UnitTestMatrix utm0 = new UnitTestMatrix(classToTrack,
        mutatorFunctionNames,
        accessorFunctionNames);
    matrices.add(utm0);
    return utm0;
  }

  /**
   * Registers a class on which coverage is to be monitored.
   *
   * @param classToTrack   the class to be watched
   * @param mutatorFunctionNames  names of non-constructor, non-static member
   *                              functions that modify the
   *                              state of the object
   * @param accessorFunctionNames names of non-static member functions that
   *                              examine but do not modify the
   *                              state of the object
   */
  private UnitTestMatrix(Class<?> classToTrack,
                         List<String> mutatorFunctionNames,
                         List<String> accessorFunctionNames)
  {
    if (get(classToTrack) == null) {
      reset(classToTrack, mutatorFunctionNames, accessorFunctionNames);
    }
  }


  /**
   * Resets a matrix to a clean state.
   * (intended for testing and internal purposes only)
   *
   * @param classToTrack   the class to be watched
   * @param mutatorFunctionNames  names of non-constructor, non-static member
   *                              functions that modify the
   *                              state of the object
   * @param accessorFunctionNames names of non-static member functions that
   *                              examine but do not modify the
   *                              state of the object
   */
  void reset(Class<?> classToTrack,
             List<String> mutatorFunctionNames,
             List<String> accessorFunctionNames)
  {
    targetClass = classToTrack;
    mutators = new ArrayList<>();
    accessors = new ArrayList<>();
    for (int i = 0; i < targetClass.getDeclaredConstructors().length; ++i) {
      mutators.add(new TrackedMember("<init>"));
    }
    for (Method m: targetClass.getDeclaredMethods()) {
      String mname = m.getName();
      for (String name: mutatorFunctionNames) {
        if (name.equals(mname)) {
          mutators.add(new TrackedMember(mname));
          break;
        }
      }

      for (String name: accessorFunctionNames) {
        if (name.equals(mname)) {
          accessors.add(new TrackedMember(mname));
          break;
        }
      }
    }

    isCovered = new boolean[mutators.size()][accessors.size()];
    for (int i = 0; i < mutators.size(); ++i) {
      for (int j = 0; j < accessors.size(); ++j) {
        isCovered[i][j] = false;
      }
    }
    numCovered = 0;
  }

  /**
   * How many mutator-accessor pairs can be associated with the given class?
   * (This is simply the produce of the number of mutator functions and the number
   * of accessor functions.)
   *
   * @return target value for mutator-accessor coverage
   */
  public int numberOfPossiblePairs() {
    return accessors.size() * mutators.size();
  }

  /**
   * A mutator-accessor pair (M,A) is covered if the accessor function A is called on an object
   * that was last modified via the mutator function M.  This fucntion reports the number of
   * mutator-accessor pairs that have been so covered.
   *
   * <p>
   * Invariant: 0 <= numberOfCoveredPairs() <= numberOfPossiblePairs()
   *
   * @return number of covered mutator-accessor pairs.
   */
  public int numberOfCoveredPairs() {
    return numCovered;
  }



  /**
   * Returns the number of mutators being tracked in the target class, including all
   * constructors and treating overloaded functions as separate instances.
   *
   * @return number of mutators
   */
  public int numberOfMutators() {
    return mutators.size();
  }

  /**
   * Returns the number of accessors being tracked in the target class,
   * treating overloaded functions as separate instances.
   *
   * @return number of mutators
   */
  public int numberOfAccessors() {
    return accessors.size();
  }

  /**
   * Mark a mutator-accessor pair as covered.
   * @param mutator name of a mutator function in the target class
   * @param mutatorLineNum line number for disambiguating overloaded functions
   * @param accessor name of an accessor function in the target class
   */
  public void covered(String mutator, int mutatorLineNum, String accessor, int accessorLineNum) {
    int kmutator = find(mutators, mutator, mutatorLineNum);
    if (kmutator < 0) {
      return;
    }
    int kaccessor = find(accessors, accessor, accessorLineNum);
    if (kaccessor < 0) {
      return;
    }
    if (!isCovered[kmutator][kaccessor]) {
      isCovered[kmutator][kaccessor] = true;
      ++numCovered;
    }

  }


  private int find(ArrayList<TrackedMember> members, String name, int line) {
    int imember = 0;
    int foundLoc = -1;
    while (imember < members.size()) {
      TrackedMember tm = members.get(imember);
      if (name.equals(tm.name)) {
        if (line == tm.line) {
          foundLoc = imember;
          break;
        } else if (tm.line == -1) {
          foundLoc = imember;
        }
      }
      ++imember;
    }
    if (foundLoc >= 0 && members.get(foundLoc).line < 0) {
      members.get(foundLoc).line = line;
    }
    return foundLoc;
  }


  /**
   * Produces a short diagnostic report indicating the total coverage
   * and listing pairs not covered.
   */
  public String toString() {
    StringBuffer out = new StringBuffer();
    out.append(targetClass.getSimpleName() + " coverage: "
        + numCovered + "/" + numberOfPossiblePairs() + "\n");
    int imutator = 0;
    for (TrackedMember m: mutators) {
      StringBuffer line = new StringBuffer();
      boolean useLine = false;
      if (m.name.equals("<init>")) {
        line.append("Constructor");
      } else {
        line.append("Mutator " + m.name);
      }
      line.append(" was not tested with accessor(s): ");
      int jaccessor = 0;
      for (TrackedMember a: accessors) {
        if (!isCovered[imutator][jaccessor]) {
          if (useLine) {
            line.append(", ");
          }  else {
            useLine = true;
          }
          line.append(a.name);
        }
        ++jaccessor;
      }
      if (useLine) {
        out.append(line.toString());
        out.append("\n");
      }
      ++imutator;
    }
    return out.toString();
  }

}
