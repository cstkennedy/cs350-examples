import os
import sys

def main():
    path_to_examine = sys.argv[1]

    files = []
    dirs = []

    wlkr = os.walk(path_to_examine)

    for root, dirs_found, files_found in wlkr:
        # Thank you... <https://stackoverflow.com/a/54673093>
        for path in files_found:
            files.append(os.path.join(root, path))

        for path in dirs_found:
            dirs.append(os.path.join(root, path))

    print("Files Identified:")
    for path in files:
        print(f"  - {path!r}")

    print()

    print("Directories Identified:")
    for path in dirs:
        print(f"  - {path!r}")


if __name__ == "__main__":
    main()
