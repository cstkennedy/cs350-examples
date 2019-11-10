#! /usr/bin/env python3

class LearningMachine(object):
    """
    Learning Machine Mock
    """

    def LearningMachine(self):
        pass

    def classify(self, featureVector):
        """
        Classify a list of features as containgin a name
        or not containing a name.

        This is a mock. If one of the features represents
        a known name return true
        """
        for feature in featureVector:
            if feature == 1:
                return True

        return False


BLOCK1 = (
"""
<NER>
Thomas J Kennedy likes Oatmeal raisin cookies!
</NER>
<NER>
Jay Morris likes pizza... and pointers to pizza.
</NER>
<NER>
I, <PER>Thomas Kennedy</PER> am awake and not asleep.. for now.
</NER>
""")

def readBlocks():
    """
    Read one input block denoted by <NER> .* </NER>
    """

    block = ""

    for line in BLOCK1.split("\n"):
        line = line.strip()

        #print("->{}<-".format(line))

        if line is None:
            pass

        if line.startswith("<NER>"):
            block = "".join(line.split(">")[1:])

        elif line.endswith("</NER>"):
            block += "".join(line.split("<")[:-1])
            yield block

        else:
            # Assume well formed input
            block += line

def blockToTokens(rawBlock):
    """
    Take a string input block and
    turn it into tokens by splitting on
    whitespace

    :rawBlock: input block
    """

    return rawBlock.split()


def tokensToWindows(tokens, k):
    """
    Generate all possible windows
    for a given set of tokens
    """

    windows = list()

    for idx, token in enumerate(tokens):
        # print(token, idx)

        window = list()

        for wIdx in range((idx - k), (idx + k + 1)):
            if wIdx < 0:
                window.append(None)
            
            elif wIdx >= len(tokens):
                window.append(None)

            else:
                window.append(tokens[wIdx])

        windows.append(window)

    return windows

def windowToFeatures(window):
    """
    @todo add documentation
    """

    windowAsFeatures = list()

    for token in window:
        windowAsFeatures.extend(tokenToFeatures(token))

    return windowAsFeatures

def tokenToFeatures(token):
    """
    @todo add documentation
    """
    knownFirstNames = ["Thomas", "Jay"]
    knownLastNames = ["Kennedy", "Morris"]

    return [
        1 if token in knownFirstNames else 0,
        1 if token in knownLastNames else 0]

def pruneWindow(window):
    """
    Remove all None placeholder entries from a window
    """

    return [token for token in window if token is not None]


def findFirstNameToken(classifiedWindows):
    """
    Given a list of classified windows in the form
    [(True, [token1, token2, ... tokenn])...]
    determine the id of the last token that is part of the name
    """

    # for i, containsNameToken, window in enumerate(reversed(classifiedWindows)):
    #     if containsName:
    #         prunedWindow = pruneWindow(window);

    #         return i

    pass

def findLastNameToken(classifiedWindows):
    """
    Given a list of classified windows in the form
    [(True, [token1, token2, ... tokenn])...]
    determine the id of the last token that is part of the name
    """

    # for containsNameToken, window in reversed(classifiedWindows):
    #     if containsName:
    #         prunedWindow = pruneWindow(window);

    #         return len(prunedWindow) - 1

    pass

def main():
    lm = LearningMachine()

    for block in readBlocks():
        print(block);
        print()

        tokens = blockToTokens(block)
        print(tokens)
        print()

        windows = tokensToWindows(tokens, 2)
        
        for w in windows:
            print(w)

        for w in windows:
            featureVector = windowToFeatures(w)

            containsName = lm.classify(featureVector)
            print(str(containsName) + " -> " + str(featureVector))

        print()

        for w in windows:
            print(pruneWindow(w))

        print()


        # Real Work
        print("*" * 80)

        tokens = blockToTokens(block)
        windows = tokensToWindows(tokens, 2)


        classifiedWindows = list()

        for w in windows:
            featureVector = windowToFeatures(w)
            containsName = lm.classify(featureVector)

            classifiedWindows.append((containsName, w))

        print(classifiedWindows)

        #print(findFirstNameToken(classifiedWindows))




if __name__ == "__main__":
    main()
