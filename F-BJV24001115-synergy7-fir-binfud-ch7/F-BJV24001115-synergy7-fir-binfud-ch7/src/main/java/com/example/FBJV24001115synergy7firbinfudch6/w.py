import os
import random
import string
import datetime

def generate_random_filename():
    random_string = ''.join(random.choices(string.ascii_letters + string.digits, k=8))
    timestamp = datetime.datetime.now().strftime("%Y%m%d%H%M%S")
    return f"{random_string}_{timestamp}.txt"

def write_files_to_txt(directory, output_file, exclude_file):
    with open(output_file, 'w', encoding='utf-8') as f_out:
        for root, dirs, files in os.walk(directory):
            for file in files:
                if file == exclude_file:
                    continue
                file_path = os.path.join(root, file)
                f_out.write(f"File Path: {file_path}\n")
                f_out.write(f"File Name: {file}\n")
                f_out.write("Contents:\n")
                try:
                    with open(file_path, 'r', encoding='utf-8') as f_in:
                        f_out.write(f_in.read())
                except Exception as e:
                    f_out.write(f"Error reading file: {e}\n")
                f_out.write("\n" + "="*40 + "\n\n")

if __name__ == "__main__":
    current_directory = os.path.dirname(os.path.abspath(__file__))
    script_name = os.path.basename(__file__)
    output_filename = generate_random_filename()
    output_file_path = os.path.join(current_directory, output_filename)
    
    write_files_to_txt(current_directory, output_file_path, script_name)
    print(f"Output written to {output_file_path}")
