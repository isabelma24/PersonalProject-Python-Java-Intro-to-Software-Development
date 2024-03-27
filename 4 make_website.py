def detect_name(file):
    """Extracts the first line of a file as name."""

    with open(file) as fin:
        _file = fin

        firstline_name = _file.readline()

        # the name on the first line could have leading or trailing whitespace
        firstline_name = firstline_name.strip()

        # raise a RuntimeError if the first character in the name string is not an uppercase letter
        if firstline_name[0] != firstline_name[0].capitalize():
            raise RuntimeError("The first line has to be a name with proper capitalization." )

    # print(firstline_name)
    return firstline_name


def detect_email(file):
    """Look for a line with an email address, with several conditions. Return the email address as a string. """

    with open(file) as fin:
        _file = fin

        lines = _file.readlines()

        email = ""
        for line in lines:
            #looking for @
            if '@' in line:
                at_index = line.index('@')
                #get the last 4 letters
                end_four = line[-4:]
                if (end_four == '.com' or end_four == '.edu'):
                    end_four_index = line.index(end_four)
                    #get the domain to check lowercase first letter
                    domain = line[at_index + 1:end_four_index]
                    if (domain[0].isalpha() and domain[0].islower()):
                        domain_ok = True
                        for i in domain:
                            #check numeric
                            if (i.isnumeric() == True):
                                domain_ok = False
                                break

                        if (domain_ok == True):
                            name = line[0:at_index]
                            #fits all requirements
                            if name.isalpha():
                                email = line
                                break

        email = email.strip()
        # print(email)
        return email.strip()


def detect_courses(file):
    """Look for the word “Courses” in the file and then extract the line that contains that word."""

    with open(file) as fin:
        _file = fin

        lines = _file.readlines()

        courses = []
        for line in lines:
            if line.startswith('Courses'):
                #find the 'Courses' and assign index, so we could find the actual course info
                courses_index = line.index('Courses')
                courses_str = line[courses_index+7:]

                first_char = -1
                for i in courses_str:
                    if i.isalpha():
                        first_char = courses_str.index(i)
                        #as long as we have a valid first_char, we can break into the next step
                        break

                if (first_char > -1):
                    courses_str = courses_str[first_char:]
                    courses = "".join(courses_str)
                    courses = courses.strip()

        # print(courses)
        return courses


def detect_projects(file):
    """Look for the word “Projects” in the file and returns the subsequent lines and stops after hitting a line with '----------'. """

    with open(file) as fin:
        _file = fin

        lines = _file.readlines()

        projects = []
        #read each line to find 'projects' also utilize the index for iteration
        for i in range(0, len(lines) - 1):
            line = lines[i]
            if line.startswith('Projects'):
                #i + 1 so it's the subsequent line
                for k in range(i + 1, len(lines) -1):
                    project = lines[k].strip()
                    if '----------' not in project:
                        #ignore the blank line
                        if project != '':
                            projects.append(project)

                break

        # print(projects)
        return projects


def surround_block(tag, text):
    """This function surrounds the given text with the given HTML tag and returns the string."""

    start_tag = "<" + tag + ">"
    end_tag = "</" + tag + ">"
    # add them together
    surrounded_text = start_tag + text + end_tag

    return surrounded_text


def create_email_link(email_address):
    """This function creates an active email link with the given email_address"""

    new_email = []

    if email_address is None:
        return None
    # iterate each letter in the given email address
    for letter in email_address:
        # display the email address with an [aT] instead of an @
        if letter == "@":
            letter = "[aT]"
            new_email.append(letter)
        else:
            new_email.append(letter)
    # it needs to be a string
    new_email = "".join(new_email)

    # return the result in html format
    # print("<a href=\"mailto:" + email_address + "\">" + new_email + "</a>")
    return "<a href=\"mailto:" + email_address + "\">" + new_email + "</a>"


def write_info_section(file):
    """Writes the information of the resume. Name and an active email link."""

    # name
    header_name = surround_block("h1", detect_name(file))
    # email
    email_linked = create_email_link(detect_email(file))

    if email_linked is None:
        email_linked = ""

    email_surrounded = surround_block("p", "Email: " + email_linked)
    # concatenate together
    info_section = surround_block("div", "\n" + header_name + email_surrounded + "\n")

    return info_section


def write_projects_section(file):
    """Writes the projects section of the resume."""

    # get the lines of the projects and assign to list variable
    project_lines = detect_projects(file)
    # h2 header
    project_surrounded = surround_block("h2", "Projects")
    # initialize new list for each line of project
    projects_surrounded = []
    # li header
    for line in project_lines:
        projects_surrounded.append(surround_block("li", line))
    # rejoin the projects from a list to a single string on the newline command.
    projects_surrounded = "\n".join(projects_surrounded)
    # ul header
    projects_surrounded_ul = surround_block("ul", "\n" + projects_surrounded + "\n")
    # div header
    projects_section = surround_block("div", "\n" + project_surrounded + "\n" + projects_surrounded_ul + "\n")

    return projects_section


def write_courses_section(file):
    """writes the courses section of the resume"""

    # get the courses as string.
    courses = detect_courses(file)
    # h3 header
    course_surrounded = surround_block("h3", "Courses")
    # span header
    courses_surrounded = surround_block("span", courses)
    # concatenate into a single string
    courses_section = surround_block("div", "\n" + course_surrounded + "\n" + courses_surrounded + "\n")

    return courses_section


def remove_last_two_lines_in_html(file_lines):
    """removing the last two lines of HTML (closing </body> and </html> tags).
     This function also adds the <div id="page-wrap">."""

    # make sure that we have enough lines in our file_lines..
    if len(file_lines) >= 2:
        # removing the last two lines
        # file_lines.pop()      # file_lines.pop()
        del file_lines[-1]
        del file_lines[-1]
        # now add the </div...
        file_lines.append("<div id=\"page-wrap\">")

    # return file_lines
    return file_lines


def add_back_last_three_lines_in_html():
    """Adds back the last two lines in a given lines list from an html file,
    these lines will be: </body> and </html>."""

    # return the last three lines as a string.
    return "\n</div>" + "\n</body>" + "\n</html>"


def read_write_resume_html(html_file, new_resume_html_file, resume_file):
    """open an existing html file, reads= the resume from a text file, and write into a new html file."""

    # write html_file.
    # Open and read resume-template.html
    resume_html_file = open(html_file, "r+")
    # Read every line of HTML
    resume_html_file_lines = resume_html_file.readlines()
    # Remove the last 2 lines of HTML
    resume_html_file_lines = remove_last_two_lines_in_html(resume_html_file_lines)
    # read resume_file
    # write the information section
    information = write_info_section(resume_file)
    # write the projects section
    projects = write_projects_section(resume_file)
    # write the courses section
    courses = write_courses_section(resume_file)
    # append info, projects and courses to resume_html_file_lines
    resume_html_file_lines.append(information)
    resume_html_file_lines.append(projects)
    resume_html_file_lines.append(courses)
    # Add the last 3 lines of HTML back in
    resume_html_file_lines.append(add_back_last_three_lines_in_html())
    # close the resume-template.html file
    resume_html_file.close()
    # write in the new output file
    write_new_resume_html_file = open(new_resume_html_file, "w")
    # Write the final HTML to a new file resume.html
    write_new_resume_html_file.writelines(resume_html_file_lines)
    # close the new output file
    write_new_resume_html_file.close()


def main():
    """This is the main function that runs our code. It uses the content from resume.txt,
     while updating the layout of resume_template.html, to output a new html - resume.html"""

    read_write_resume_html('resume_template.html', 'resume.html', 'resume.txt')


# entry point for our main function.
if __name__ == '__main__':
    main()
