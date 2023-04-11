CREATE TABLE governorate (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   name VARCHAR(255) NOT NULL,
   name_ar VARCHAR(255) NOT NULL,
   CONSTRAINT pk_governorate PRIMARY KEY (id)
);
CREATE TABLE specialty (
  id BIGINT NOT NULL,
   name VARCHAR(255) NOT NULL,
   name_ar VARCHAR(255) NOT NULL,
   image VARCHAR(255) NOT NULL,
   doctor_id BIGINT,
   CONSTRAINT pk_specialty PRIMARY KEY (id)
);
CREATE TABLE doctor (
  id BIGINT NOT NULL,
   name VARCHAR(255) NOT NULL,
   name_ar VARCHAR(255) NOT NULL,
   image VARCHAR(255) NOT NULL,
   clinic_id BIGINT,
   CONSTRAINT pk_doctor PRIMARY KEY (id)
);
CREATE TABLE address (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   name VARCHAR(255) NOT NULL,
   name_ar VARCHAR(255) NOT NULL,
   governorate_id BIGINT,
   clinic_id BIGINT,
   CONSTRAINT pk_address PRIMARY KEY (id)
);
CREATE TABLE clinic (
  id BIGINT NOT NULL,
   name VARCHAR(255) NOT NULL,
   name_ar VARCHAR(255) NOT NULL,
   image VARCHAR(255) NOT NULL,
   phone_number VARCHAR(255) NOT NULL,
   CONSTRAINT pk_clinic PRIMARY KEY (id)
);

CREATE TABLE "user" (
  id BIGINT NOT NULL,
   phone VARCHAR(255) NOT NULL,
   password TEXT NOT NULL,
   age INT NOT NULL,
   gender VARCHAR(255) NOT NULL,
   image TEXT NOT NULL,
   name VARCHAR(255) NOT NULL,
   CONSTRAINT pk_user PRIMARY KEY (id)
);

ALTER TABLE address ADD CONSTRAINT FK_ADDRESS_ON_CLINIC FOREIGN KEY (clinic_id) REFERENCES clinic (id);
ALTER TABLE address ADD CONSTRAINT FK_ADDRESS_ON_GOVERNORATE FOREIGN KEY (governorate_id) REFERENCES governorate (id);
ALTER TABLE doctor ADD CONSTRAINT FK_DOCTOR_ON_CLINIC FOREIGN KEY (clinic_id) REFERENCES clinic (id);
ALTER TABLE specialty ADD CONSTRAINT FK_SPECIALTY_ON_DOCTOR FOREIGN KEY (doctor_id) REFERENCES doctor (id);

INSERT INTO governorate (name, name_ar) VALUES
    ('Cairo', 'القاهرة'),
    ('Alexandria', 'الإسكندرية'),
    ('Giza', 'الجيزة'),
    ('Suez', 'السويس');

-- Insert data into clinic table
INSERT INTO clinic (id, name, name_ar, image, phone_number) VALUES
    (1, 'ABC Clinic', 'عيادة ABC', 'clinic_abc.jpg', '0111111111'),
    (2, 'XYZ Clinic', 'عيادة XYZ', 'clinic_xyz.jpg', '0222222222');

-- Insert data into doctor table
INSERT INTO doctor (id, name, name_ar, image, clinic_id) VALUES
    (1, 'Dr. John Smith', 'الدكتور جون سميث', 'dr_john.jpg', 1),
    (2, 'Dr. Ahmed Hassan', 'الدكتور أحمد حسن', 'dr_ahmed.jpg', 2);

-- Insert data into specialty table
INSERT INTO specialty (id, name, name_ar, image, doctor_id) VALUES
    (1, 'Cardiology', 'القلبية', 'cardiology.jpg', 1),
    (2, 'Dermatology', 'الأمراض الجلدية', 'dermatology.jpg', 2);

-- Insert data into address table
INSERT INTO address (name, name_ar, governorate_id, clinic_id) VALUES
    ('123 Main St', 'شارع المركز الرئيسي 123', 1, 1),
    ('456 Broad St', 'شارع برود 456', 2, 2);


    -- More governorate data
    INSERT INTO governorate (name, name_ar) VALUES
        ('Gharbia', 'الغربية'),
        ('Dakahlia', 'الدقهلية'),
        ('Qalyubia', 'القليوبية'),
        ('Sharqia', 'الشرقية');

    -- More clinic data
    INSERT INTO clinic (id, name, name_ar, image, phone_number) VALUES
        (3, 'ABC Clinic 2', 'عيادة ABC 2', 'clinic_abc2.jpg', '0333333333'),
        (4, 'XYZ Clinic 2', 'عيادة XYZ 2', 'clinic_xyz2.jpg', '0444444444');

    -- More doctor data
    INSERT INTO doctor (id, name, name_ar, image, clinic_id) VALUES
        (3, 'Dr. Sarah Johnson', 'الدكتورة سارة جونسون', 'dr_sarah.jpg', 3),
        (4, 'Dr. Mohamed Ali', 'الدكتور محمد علي', 'dr_mohamed.jpg', 4);

    -- More specialty data
    INSERT INTO specialty (id, name, name_ar, image, doctor_id) VALUES
        (3, 'Neurology', 'الأعصاب', 'neurology.jpg', 3),
        (4, 'Ophthalmology', 'العيون', 'ophthalmology.jpg', 4);

    -- More address data
    INSERT INTO address (name, name_ar, governorate_id, clinic_id) VALUES
        ('789 High St', 'شارع هاي 789', 3, 3),
        ('321 Main St', 'شارع المركز الرئيسي 321', 4, 4);

    INSERT INTO "user" (id, phone, password, age, gender, image) VALUES
        (1, '123456789', 'password123', 25, 'male', 'image1.jpg'),
        (2, '987654321', 'password456', 32, 'female', 'image2.jpg'),
        (3, '555555555', 'password789', 18, 'non-binary', 'image3.jpg'),
        (4, '999999999', 'passwordabc', 40, 'male', 'image4.jpg');
