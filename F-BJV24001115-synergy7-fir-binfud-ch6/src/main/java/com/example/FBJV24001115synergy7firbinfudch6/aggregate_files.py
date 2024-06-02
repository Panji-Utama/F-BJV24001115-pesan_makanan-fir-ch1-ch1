import os

def aggregate_files(output_file):
    script_name = os.path.basename(__file__)  # Get the name of the script file
    output_file_path = os.path.abspath(output_file)  # Get the absolute path of the output file

    with open(output_file, 'w', encoding='utf-8') as out_file:
        for root, _, files in os.walk(os.getcwd()):
            for file_name in files:
                file_path = os.path.abspath(os.path.join(root, file_name))
                
                # Skip the script file and the output file itself
                if file_name == script_name or file_path == output_file_path:
                    continue

                try:
                    with open(file_path, 'r', encoding='utf-8') as in_file:
                        out_file.write(f"// {file_path}\n")
                        for line in in_file:
                            out_file.write(line)
                        out_file.write(f"\n// End of {file_name}\n\n")
                except Exception as e:
                    print(f"Error reading {file_path}: {e}")

if __name__ == "__main__":
    output_file = input("Enter the name of the output text file (with .txt extension): ")
    aggregate_files(output_file)
    print(f"All files have been aggregated into {output_file}")
