create database feb26;

 

CREATE TABLE departments
     (department_id    int  PRIMARY KEY,
      department_name  VARCHAR(30)  NOT NULL
     );
 
CREATE TABLE hr.jobs
  (job_id         VARCHAR(10)  PRIMARY KEY,
   job_title      VARCHAR(35)  NOT NULL,
   min_salary     int, 
   max_salary     int
  );
     
     
    
CREATE TABLE hr.employees
(   employee_id    INTEGER  auto_increment primary key,
    first_name     VARCHAR(20),
    last_name      VARCHAR(25),
    email          VARCHAR(25) NOT NULL UNIQUE,
    hire_date      DATE NOT NULL,
    job_id         VARCHAR(10)  NOT NULL REFERENCES jobs(job_id),
    salary         INTEGER  CHECK (salary > 0),
    department_id  INTEGER  REFERENCES departments(department_id) 
);

  

INSERT INTO departments VALUES ( 10,'Administration');
INSERT INTO departments VALUES ( 20,'Marketing' );
INSERT INTO departments VALUES ( 30,'Purchasing');
INSERT INTO departments VALUES ( 40,'Human Resources');
INSERT INTO departments VALUES ( 50,'Shipping');
INSERT INTO departments VALUES ( 60,'IT');
INSERT INTO departments VALUES ( 70,'Public Relations');
INSERT INTO departments VALUES ( 80,'Sales');
                
INSERT INTO jobs VALUES( 'AD_PRES', 'President' , 20080 , 40000 );
INSERT INTO jobs VALUES( 'AD_VP', 'Administration Vice President', 15000, 30000);
INSERT INTO jobs VALUES( 'FI_MGR', 'Finance Manager', 8200, 16000);
INSERT INTO jobs VALUES( 'FI_ACCOUNT', 'Accountant', 4200, 9000);
INSERT INTO jobs VALUES( 'AC_MGR', 'Accounting Manager', 8200, 16000);
INSERT INTO jobs VALUES( 'AC_ACCOUNT', 'Public Accountant', 4200, 9000);
INSERT INTO jobs VALUES( 'SA_MAN', 'Sales Manager', 10000 , 20080 );
INSERT INTO jobs VALUES( 'SA_REP', 'Sales Representative' , 6000 , 12008 );
INSERT INTO jobs VALUES( 'IT_PROG', 'Programmer', 4000, 10000);

INSERT INTO employees VALUES 
        ( 100
        , 'Steven'
        , 'King'
        , 'SKING'
        , '2019-10-10',
        , 'AD_PRES'
        , 24000
        , 10
        );

INSERT INTO employees VALUES 
        ( 101
        , 'Neena'
        , 'Kochhar'
        , 'NKOCHHAR'
        , '2015-09-05'
        , 'AD_VP'
        , 17000
        , 10
        );

INSERT INTO employees VALUES 
        ( 102
        , 'Lex'
        , 'De Haan'
        , 'LDEHAAN'
        , '2000-01-20'
        , 'AD_VP'
        , 17000
        , 20
        );

INSERT INTO employees VALUES 
        ( 103
        , 'Alexander'
        , 'Hunold'
        , 'AHUNOLD'
        , '2006-10-11'
        , 'IT_PROG'
        , 9000
        , 60
        );

INSERT INTO employees VALUES 
        ( 104
        , 'Bruce'
        , 'Ernst'
        , 'BERNST'
        , '2007-05-21'
        , 'IT_PROG'
        , 6000
        , 60
        );

INSERT INTO employees VALUES 
        ( 105
        , 'David'
        , 'Austin'
        , 'DAUSTIN'
        , '2008-06-21'
        , 'IT_PROG'
        , 4800
        , 60
        );

INSERT INTO employees VALUES 
        ( 106
        , 'Valli'
        , 'Pataballa'
        , 'VPATABAL'
        , '2010-01-20'
        , 'IT_PROG'
        , 4800
        , 60
        );

INSERT INTO employees VALUES 
        ( 107
        , 'Diana'
        , 'Lorentz'
        , 'DLORENTZ'
        , '2012-12-12'
        , 'IT_PROG'
        , 4200
        , 60
        );

INSERT INTO employees VALUES 
        ( 108
        , 'Nancy'
        , 'Greenberg'
        , 'NGREENBE'
        , '2013-10-11'
        , 'FI_MGR'
        , 12000
        , 100
        );

INSERT INTO employees VALUES 
        ( 109
        , 'Daniel'
        , 'Faviet'
        , 'DFAVIET'
        , '2012-11-01'
        , 'FI_ACCOUNT'
        , 9000
        , 100
        );

INSERT INTO employees VALUES 
        ( 110
        , 'John'
        , 'Chen'
        , 'JCHEN'
        , '2016-01-01'
        , 'FI_ACCOUNT'
        , 8200
        , 30
        );

INSERT INTO employees VALUES 
        ( 111
        , 'Ismael'
        , 'Sciarra'
        , 'ISCIARRA'
        , '2011-05-06'
        , 'FI_ACCOUNT'
        , 7700
        , 30
        );

INSERT INTO employees VALUES 
        ( 112
        , 'Jose Manuel'
        , 'Urman'
        , 'JMURMAN'
        , '2019-10-10'
        , 'FI_ACCOUNT'
        , 7800
        , 30
        );

INSERT INTO employees VALUES 
        ( 113
        , 'Luis'
        , 'Popp'
        , 'LPOPP'
        , '2017-02-08'
        , 'FI_ACCOUNT'
        , 6900
        , 30
        );

INSERT INTO employees VALUES 
        ( 114
        , 'Den'
        , 'Raphaely'
        , 'DRAPHEAL'
        , '2018-03-10'
        , 'PU_MAN'
        , 11000
        , 30
        );


INSERT INTO employees VALUES 
        ( 115
        , 'Matthew'
        , 'Weiss'
        , 'MWEISS'
        , '2016-11-11'
        , 'SA_MAN'
        , 8000
        , 80
        );

