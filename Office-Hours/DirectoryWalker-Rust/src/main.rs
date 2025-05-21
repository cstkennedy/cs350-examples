use walkdir::WalkDir;

fn main() {
    let path_to_examine = std::env::args().nth(1).expect("No path was specified");

    let (files, dirs) = {
        let mut files = Vec::new();
        let mut dirs = Vec::new();

        let wlkr = WalkDir::new(&path_to_examine);

        for entry in wlkr.into_iter() {
            let entry = entry.unwrap();

            if entry.file_type().is_file() {
                files.push(entry.into_path());
            }
            else if entry.file_type().is_dir() {
                dirs.push(entry.into_path());
            }
        }

        (files, dirs)
    };

    println!("Files Identified:");
    for file in files.iter() {
        println!("  - {:?}", file);
    }
    println!();

    println!("Directories Identified:");
    for dir in dirs.iter() {
        println!("  - {:?}", dir);
    }
}
