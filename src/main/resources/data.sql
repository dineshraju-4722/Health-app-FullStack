INSERT INTO specialization (name) VALUES 
('Cardiologist'),
('Dermatologist'),
('Neurologist'),
('Pediatrician'),
('Orthopedic'),
('Psychiatrist'),
('Dentist'),
('Gynecologist'),
('Ophthalmologist'), 
('General Physician') on conflict(name) do nothing;


INSERT INTO hospital (name, location, email, contact)
VALUES
  ('Apollo Hospital', 'Chennai', 'apollo@hospital.com', '044-24567890'),
  ('Fortis Healthcare', 'Bengaluru', 'fortis@hospital.com', '080-33445566'),
  ('AIIMS Delhi', 'New Delhi', 'aiims@hospital.com', '011-26789900'),
  ('CMC Vellore', 'Vellore', 'cmc@hospital.com', '0416-2281000'),
  ('Manipal Hospital', 'Hyderabad', 'manipal@hospital.com', '040-22334455'),
  ('Max Super Specialty', 'Mumbai', 'max@hospital.com', '022-55667788'),
  ('Narayana Health', 'Kolkata', 'narayana@hospital.com', '033-33224455'),
  ('KIMS Hospital', 'Thiruvananthapuram', 'kims@hospital.com', '0471-2558999'),
  ('Care Hospital', 'Pune', 'care@hospital.com', '020-66778899'),
  ('Medanta Hospital', 'Gurugram', 'medanta@hospital.com', '0124-4141414')
ON CONFLICT (name,email) DO NOTHING;


INSERT INTO doctor (imglink, name, email, contact, status, experience, specialization_id, hospital_id)
VALUES
-- Cardiologist (Apollo Hospital)
('https://randomuser.me/api/portraits/men/11.jpg', 'Dr. Arjun Mehta', 'arjun.mehta@apollo.com', '9876543210', 'false', '12 years', 1, 1),
('https://randomuser.me/api/portraits/women/12.jpg', 'Dr. Kavya Rao', 'kavya.rao@apollo.com', '9812345678', 'false', '8 years', 1, 1),

-- Dermatologist (Fortis Healthcare)
('https://randomuser.me/api/portraits/men/13.jpg', 'Dr. Rohan Sharma', 'rohan.sharma@fortis.com', '9823456789', 'false', '10 years', 2, 2),
('https://randomuser.me/api/portraits/women/14.jpg', 'Dr. Priya Nair', 'priya.nair@fortis.com', '9898123456', 'false', '6 years', 2, 2),

-- Neurologist (AIIMS Delhi)
('https://randomuser.me/api/portraits/men/15.jpg', 'Dr. Karthik Iyer', 'karthik.iyer@aiims.com', '9765432190', 'false', '11 years', 3, 3),
('https://randomuser.me/api/portraits/women/16.jpg', 'Dr. Ananya Gupta', 'ananya.gupta@aiims.com', '9845672310', 'false', '7 years', 3, 3),

-- Pediatrician (CMC Vellore)
('https://randomuser.me/api/portraits/men/17.jpg', 'Dr. Vivek Deshmukh', 'vivek.deshmukh@cmc.com', '9832109876', 'false', '9 years', 4, 4),
('https://randomuser.me/api/portraits/women/18.jpg', 'Dr. Meera Reddy', 'meera.reddy@cmc.com', '9798123400', 'false', '5 years', 4, 4),

-- Orthopedic (Manipal Hospital)
('https://randomuser.me/api/portraits/men/19.jpg', 'Dr. Aditya Verma', 'aditya.verma@manipal.com', '9811223344', 'false', '13 years', 5, 5),
('https://randomuser.me/api/portraits/women/20.jpg', 'Dr. Nisha Bhat', 'nisha.bhat@manipal.com', '9876123409', 'false', '8 years', 5, 5),

-- Psychiatrist (Max Super Specialty)
('https://randomuser.me/api/portraits/men/21.jpg', 'Dr. Arvind Menon', 'arvind.menon@max.com', '9822001122', 'false', '15 years', 6, 6),
('https://randomuser.me/api/portraits/women/22.jpg', 'Dr. Shruti Pillai', 'shruti.pillai@max.com', '9811998877', 'false', '9 years', 6, 6),

-- Dentist (Narayana Health)
('https://randomuser.me/api/portraits/men/23.jpg', 'Dr. Rajesh Nair', 'rajesh.nair@narayana.com', '9877009988', 'false', '10 years', 7, 7),
('https://randomuser.me/api/portraits/women/24.jpg', 'Dr. Neha Patil', 'neha.patil@narayana.com', '9866112233', 'false', '6 years', 7, 7),

-- Gynecologist (KIMS Hospital)
('https://randomuser.me/api/portraits/men/25.jpg', 'Dr. Suresh Kumar', 'suresh.kumar@kims.com', '9888776655', 'false', '12 years', 8, 8),
('https://randomuser.me/api/portraits/women/26.jpg', 'Dr. Anjali Menon', 'anjali.menon@kims.com', '9810087654', 'false', '10 years', 8, 8),

-- Ophthalmologist (Care Hospital)
('https://randomuser.me/api/portraits/men/27.jpg', 'Dr. Ritesh Jain', 'ritesh.jain@care.com', '9876504321', 'false', '11 years', 9, 9),
('https://randomuser.me/api/portraits/women/28.jpg', 'Dr. Divya Kapoor', 'divya.kapoor@care.com', '9854231900', 'false', '8 years', 9, 9),

-- General Physician (Medanta Hospital)
('https://randomuser.me/api/portraits/men/29.jpg', 'Dr. Manoj Tiwari', 'manoj.tiwari@medanta.com', '9845123678', 'false', '14 years', 10, 10),
('https://randomuser.me/api/portraits/women/30.jpg', 'Dr. Reema Singh', 'reema.singh@medanta.com', '9823451199', 'false', '7 years', 10, 10)
ON CONFLICT (email) DO NOTHING;
;


INSERT INTO users (name, email, password, role) VALUES
-- Cardiologists
('Dr. Arjun Mehta', 'arjun.mehta@apollo.com', '{noop}password', 'doctor'),
('Dr. Kavya Rao', 'kavya.rao@apollo.com', '{noop}password', 'doctor'),

-- Dermatologists
('Dr. Rohan Sharma', 'rohan.sharma@fortis.com', '{noop}password', 'doctor'),
('Dr. Priya Nair', 'priya.nair@fortis.com', '{noop}password', 'doctor'),

-- Neurologists
('Dr. Karthik Iyer', 'karthik.iyer@aiims.com', '{noop}password', 'doctor'),
('Dr. Ananya Gupta', 'ananya.gupta@aiims.com', '{noop}password', 'doctor'),

-- Pediatricians
('Dr. Vivek Deshmukh', 'vivek.deshmukh@cmc.com', '{noop}password', 'doctor'),
('Dr. Meera Reddy', 'meera.reddy@cmc.com', '{noop}password', 'doctor'),

-- Orthopedic
('Dr. Aditya Verma', 'aditya.verma@manipal.com', '{noop}password', 'doctor'),
('Dr. Nisha Bhat', 'nisha.bhat@manipal.com', '{noop}password', 'doctor'),

-- Psychiatrists
('Dr. Arvind Menon', 'arvind.menon@max.com', '{noop}password', 'doctor'),
('Dr. Shruti Pillai', 'shruti.pillai@max.com', '{noop}password', 'doctor'),

-- Dentists
('Dr. Rajesh Nair', 'rajesh.nair@narayana.com', '{noop}password', 'doctor'),
('Dr. Neha Patil', 'neha.patil@narayana.com', '{noop}password', 'doctor'),

-- Gynecologists
('Dr. Suresh Kumar', 'suresh.kumar@kims.com', '{noop}password', 'doctor'),
('Dr. Anjali Menon', 'anjali.menon@kims.com', '{noop}password', 'doctor'),

-- Ophthalmologists
('Dr. Ritesh Jain', 'ritesh.jain@care.com', '{noop}password', 'doctor'),
('Dr. Divya Kapoor', 'divya.kapoor@care.com', '{noop}password', 'doctor'),

-- General Physicians
('Dr. Manoj Tiwari', 'manoj.tiwari@medanta.com', '{noop}password', 'doctor'),
('Dr. Reema Singh', 'reema.singh@medanta.com', '{noop}password', 'doctor'),

-- Custom Users
('Raju', 'dineshsandireddy08@gmail.com', '{noop}Raju@4722', 'user'),
('Dr. Raju', 'raju47222274@gmail.com', '{noop}Raju@4722', 'doctor')
ON CONFLICT (email) DO NOTHING;


 

