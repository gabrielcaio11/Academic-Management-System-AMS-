-- =====================================
-- COURSES
-- =====================================
CREATE TABLE courses (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL
);

-- =====================================
-- PROFESSORS
-- =====================================
CREATE TABLE professors (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    employee_code VARCHAR(255) NOT NULL UNIQUE
);

-- =====================================
-- STUDENTS
-- =====================================
CREATE TABLE students (
    id BIGSERIAL PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    registration_number VARCHAR(255) NOT NULL UNIQUE,
    birth_date DATE NOT NULL
);

-- =====================================
-- CLASS GROUPS
-- =====================================
CREATE TABLE class_groups (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    semester VARCHAR(255),
    max_students INTEGER NOT NULL,
    course_id BIGINT NOT NULL,
    professor_id BIGINT NOT NULL,

    CONSTRAINT fk_class_groups_course
        FOREIGN KEY (course_id)
        REFERENCES courses(id)
        ON DELETE RESTRICT,

    CONSTRAINT fk_class_groups_professor
        FOREIGN KEY (professor_id)
        REFERENCES professors(id)
        ON DELETE RESTRICT
);

-- =====================================
-- ENROLLMENTS
-- =====================================
CREATE TABLE enrollments (
    id BIGSERIAL PRIMARY KEY,
    student_id BIGINT NOT NULL,
    class_group_id BIGINT NOT NULL,
    enrollment_date DATE NOT NULL,

    CONSTRAINT fk_enrollment_student
        FOREIGN KEY (student_id)
        REFERENCES students(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_enrollment_class_groups
        FOREIGN KEY (class_group_id)
        REFERENCES class_groups(id)
        ON DELETE CASCADE,

    CONSTRAINT uk_enrollment_student_class
        UNIQUE (student_id, class_group_id)
);

-- =====================================
-- GRADES
-- =====================================
CREATE TABLE grades (
    id BIGSERIAL PRIMARY KEY,
    enrollment_id BIGINT NOT NULL UNIQUE,
    value DOUBLE PRECISION NOT NULL,

    CONSTRAINT fk_grade_enrollment
        FOREIGN KEY (enrollment_id)
        REFERENCES enrollments(id)
        ON DELETE CASCADE
);