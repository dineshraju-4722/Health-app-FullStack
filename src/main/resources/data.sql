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