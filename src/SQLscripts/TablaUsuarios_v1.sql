--------------------------------------------------------
-- Archivo creado  - domingo-abril-28-2024   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table USUARIOS
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."USUARIOS" 
   (	"CODIGO" VARCHAR2(20 BYTE), 
	"USUARIO" VARCHAR2(50 BYTE), 
	"CLAVE" VARCHAR2(100 BYTE), 
	"NOMBRE" VARCHAR2(100 BYTE), 
	"CORREO" VARCHAR2(100 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into SYSTEM.USUARIOS
SET DEFINE OFF;
Insert into SYSTEM.USUARIOS (CODIGO,USUARIO,CLAVE,NOMBRE,CORREO) values ('104619031542','cardila','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','CARLOOS ARDILA','cardila@unicauca.edu.co');
Insert into SYSTEM.USUARIOS (CODIGO,USUARIO,CLAVE,NOMBRE,CORREO) values ('104619031543','johnsmith','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','John Smith','johnsmith@unicauca.edu.co');
Insert into SYSTEM.USUARIOS (CODIGO,USUARIO,CLAVE,NOMBRE,CORREO) values ('104619031544','mariasanchez','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','María Sanchez','mariasanchez@unicauca.edu.co');
Insert into SYSTEM.USUARIOS (CODIGO,USUARIO,CLAVE,NOMBRE,CORREO) values ('104619031545','javierlopez','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','Javier Lopez','javierlopez@unicauca.edu.co');
Insert into SYSTEM.USUARIOS (CODIGO,USUARIO,CLAVE,NOMBRE,CORREO) values ('104619031546','sofiagarcia','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','Sofia Garcia','sofiagarcia@unicauca.edu.co');
Insert into SYSTEM.USUARIOS (CODIGO,USUARIO,CLAVE,NOMBRE,CORREO) values ('104619031547','davidmartinez','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','David Martinez','davidmartinez@unicauca.edu.co');
Insert into SYSTEM.USUARIOS (CODIGO,USUARIO,CLAVE,NOMBRE,CORREO) values ('104619031548','anaperez','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','Ana Perez','anaperez@unicauca.edu.co');
Insert into SYSTEM.USUARIOS (CODIGO,USUARIO,CLAVE,NOMBRE,CORREO) values ('104619031549','juliorodriguez','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','Julio Rodriguez','juliorodriguez@unicauca.edu.co');
Insert into SYSTEM.USUARIOS (CODIGO,USUARIO,CLAVE,NOMBRE,CORREO) values ('104619031550','luciafernandez','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','Lucía Fernandez','luciafernandez@unicauca.edu.co');
Insert into SYSTEM.USUARIOS (CODIGO,USUARIO,CLAVE,NOMBRE,CORREO) values ('104619031551','carlosruiz','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','Carlos Ruiz','carlosruiz@unicauca.edu.co');
Insert into SYSTEM.USUARIOS (CODIGO,USUARIO,CLAVE,NOMBRE,CORREO) values ('104619031552','patriciagonzalez','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','Patricia Gonzalez','patriciagonzalez@unicauca.edu.co');
--------------------------------------------------------
--  DDL for Index SYS_C008330
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYSTEM"."SYS_C008330" ON "SYSTEM"."USUARIOS" ("CODIGO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table USUARIOS
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."USUARIOS" ADD PRIMARY KEY ("CODIGO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
