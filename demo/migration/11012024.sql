ALTER TABLE patient_data ADD COLUMN created_at TIMESTAMP DEFAULT NOW()

ALTER TABLE patient_data ADD COLUMN updated_at TIMESTAMP DEFAULT NOW()

ALTER TABLE patient_data ADD COLUMN deleted_at TIMESTAMP

alter table patient_data add column created_by varchar(20), add column updated_by varchar(20), add column deleted_by varchar(20)

drop table patient_data

CREATE TABLE patient_data (
  patient_identity VARCHAR(20),
  first_name VARCHAR(50),
  last_name VARCHAR(50),
  date_of_birth VARCHAR(20),
  gender VARCHAR(10),
  address VARCHAR(100),
  suburb varchar(20),
  state varchar(20),
  post_code numeric(10,0),
  phone_number VARCHAR(20),
  created_at TIMESTAMP DEFAULT NOW() not null,
  created_by varchar(20),
  updated_at TIMESTAMP DEFAULT NOW() not null,
  updated_by varchar(20),
  deleted_at TIMESTAMP,
  deleted_by varchar(20)
);