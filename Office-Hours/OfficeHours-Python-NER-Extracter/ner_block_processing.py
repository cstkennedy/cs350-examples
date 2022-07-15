#! /usr/bin/env python3


class LearningMachine:
    """
    Learning Machine Mock
    """

    def LearningMachine(self):
        pass

    def classify(self, feature_vector):
        """
        Classify a list of features as containgin a name
        or not containing a name.

        This is a mock. If one of the features represents
        a known name return true
        """

        for feature in feature_vector:
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


def read_blocks():
    """
    Read one input block denoted by <NER> .* </NER>
    """

    block = ""

    for line in BLOCK1.split("\n"):
        line = line.strip()

        # print("->{}<-".format(line))

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


def block_to_tokens(raw_block):
    """
    Take a string input block and
    turn it into tokens by splitting on
    whitespace

    :raw_block: input block
    """

    return raw_block.split()


def tokens_to_windows(tokens, k):
    """
    Generate all possible windows
    for a given set of tokens
    """

    windows = []

    for idx, token in enumerate(tokens):
        # print(token, idx)

        window = []

        for w_idx in range((idx - k), (idx + k + 1)):
            if w_idx < 0:
                window.append(None)

            elif w_idx >= len(tokens):
                window.append(None)

            else:
                window.append(tokens[w_idx])

        windows.append(window)

    return windows


def window_to_features(window):
    """
    @todo add documentation
    """

    window_as_features = []

    for token in window:
        window_as_features.extend(token_to_features(token))

    return window_as_features


def token_to_features(token):
    """
    @todo add documentation
    """
    known_first_names = ["Thomas", "Jay"]
    known_last_names = ["Kennedy", "Morris"]

    return [1 if token in known_first_names else 0,
            1 if token in known_last_names else 0]


def prune_window(window):
    """
    Remove all None placeholder entries from a window
    """

    return [token for token in window if token is not None]


def find_first_name_token(classified_windows):
    """
    Given a list of classified windows in the form
    [(True, [token1, token2, ... tokenn])...]
    determine the id of the last token that is part of the name
    """

    # for i, contains_name_token, window in enumerate(reversed(classified_windows)):
    #     if contains_name:
    #         pruned_window = prune_window(window);

    #         return i


def find_last_name_token(classified_windows):
    """
    Given a list of classified windows in the form
    [(True, [token1, token2, ... tokenn])...]
    determine the id of the last token that is part of the name
    """

    # for contains_name_token, window in reversed(classified_windows):
    #     if contains_name:
    #         pruned_window = prune_window(window);

    #         return len(pruned_window) - 1


def main():
    machine = LearningMachine()

    for block in read_blocks():
        print(block)
        print()

        tokens = block_to_tokens(block)
        print(tokens)
        print()

        windows = tokens_to_windows(tokens, 2)

        for w in windows:
            print(w)

        for w in windows:
            feature_vector = window_to_features(w)

            contains_name = machine.classify(feature_vector)
            print(str(contains_name) + " -> " + str(feature_vector))

        print()

        for w in windows:
            print(prune_window(w))

        print()

        # Real Work
        print("*" * 80)

        tokens = block_to_tokens(block)
        windows = tokens_to_windows(tokens, 2)

        classified_windows = []

        for w in windows:
            feature_vector = window_to_features(w)
            contains_name = machine.classify(feature_vector)

            classified_windows.append((contains_name, w))

        print(classified_windows)

        # print(find_first_name_token(classified_windows))


if __name__ == "__main__":
    main()
