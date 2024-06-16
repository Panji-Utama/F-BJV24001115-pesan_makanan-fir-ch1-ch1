--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

-- Started on 2024-05-17 21:42:17

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE binarfud_panji;
--
-- TOC entry 3368 (class 1262 OID 16401)
-- Name: binarfud_panji; Type: DATABASE; Schema: -; Owner: -
--

CREATE DATABASE binarfud_panji WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';


\connect binarfud_panji

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 5 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: -
--

CREATE SCHEMA public;


--
-- TOC entry 3369 (class 0 OID 0)
-- Dependencies: 5
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- TOC entry 232 (class 1255 OID 16507)
-- Name: procedure_create_user(character varying, character varying, character varying); Type: PROCEDURE; Schema: public; Owner: -
--

CREATE PROCEDURE public.procedure_create_user(IN c_username character varying, IN c_email character varying, IN c_pw character varying)
    LANGUAGE sql
    AS $$ 
insert into users (id, username, email_address, password, created_date, updated_date)
values (uuid_generate_v4(), c_username, c_email, c_pw, NOW(), NOW())
$$;


--
-- TOC entry 231 (class 1255 OID 16505)
-- Name: procedure_delete_user(uuid); Type: PROCEDURE; Schema: public; Owner: -
--

CREATE PROCEDURE public.procedure_delete_user(IN d_id uuid)
    LANGUAGE sql
    AS $$
DELETE FROM users
WHERE id = d_id;
$$;


--
-- TOC entry 230 (class 1255 OID 16503)
-- Name: procedure_update_user(uuid, character varying, character varying, character varying); Type: PROCEDURE; Schema: public; Owner: -
--

CREATE PROCEDURE public.procedure_update_user(IN new_id uuid, IN new_username character varying, IN new_email character varying, IN new_password character varying)
    LANGUAGE sql
    AS $$ 
update users
set 
username = new_username, 
email_address = new_email, 
password = new_password
where id = new_id
$$;


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 215 (class 1259 OID 16434)
-- Name: merchant; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.merchant (
    id uuid NOT NULL,
    created_date timestamp(6) without time zone NOT NULL,
    deleted_date timestamp(6) without time zone,
    updated_date timestamp(6) without time zone NOT NULL,
    merchant_location character varying(255),
    merchant_name character varying(255),
    open boolean
);


--
-- TOC entry 216 (class 1259 OID 16441)
-- Name: order_detail; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.order_detail (
    id uuid NOT NULL,
    created_date timestamp(6) without time zone NOT NULL,
    deleted_date timestamp(6) without time zone,
    updated_date timestamp(6) without time zone NOT NULL,
    quantity integer,
    total_price numeric(38,2),
    order_id uuid,
    product_id uuid
);


--
-- TOC entry 219 (class 1259 OID 16468)
-- Name: orders; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.orders (
    id uuid NOT NULL,
    created_date timestamp(6) without time zone NOT NULL,
    deleted_date timestamp(6) without time zone,
    updated_date timestamp(6) without time zone NOT NULL,
    completed boolean,
    destination_address character varying(255),
    order_time timestamp(6) without time zone,
    user_id uuid
);


--
-- TOC entry 217 (class 1259 OID 16446)
-- Name: product; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.product (
    id uuid NOT NULL,
    created_date timestamp(6) without time zone NOT NULL,
    deleted_date timestamp(6) without time zone,
    updated_date timestamp(6) without time zone NOT NULL,
    price double precision,
    product_name character varying(255),
    merchant_id uuid
);


--
-- TOC entry 218 (class 1259 OID 16451)
-- Name: users; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.users (
    id uuid NOT NULL,
    created_date timestamp(6) without time zone NOT NULL,
    deleted_date timestamp(6) without time zone,
    updated_date timestamp(6) without time zone NOT NULL,
    email_address character varying(255),
    password character varying(255),
    username character varying(255)
);


--
-- TOC entry 3358 (class 0 OID 16434)
-- Dependencies: 215
-- Data for Name: merchant; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.merchant VALUES ('9d715b02-a53b-4b4d-81fd-83d1f3696c8c', '2024-05-03 19:50:48.796', NULL, '2024-05-03 19:50:48.796', 'Jakarta', 'Test Merchant', true);
INSERT INTO public.merchant VALUES ('59becb29-7809-46f7-8b3e-6e73582e8962', '2024-05-03 19:46:12.188', NULL, '2024-05-05 20:56:23.289', 'Bandung', 'Warung Ayam', true);
INSERT INTO public.merchant VALUES ('06bb7eb1-2a46-40a6-8b5c-f3931e91383b', '2024-05-06 00:29:15.579', NULL, '2024-05-06 00:29:15.579', 'Surabaya', 'Warteg', true);
INSERT INTO public.merchant VALUES ('7d8473a2-aaa0-4c30-8951-4fc2a65c8536', '2024-05-06 00:30:30.288', NULL, '2024-05-06 00:30:56.066', 'Malang', 'DBest', false);
INSERT INTO public.merchant VALUES ('d8bf80b4-0f08-4e32-82f5-3fa0031756c9', '2024-05-17 02:21:16.7', '2024-05-17 02:24:54.297', '2024-05-17 02:24:54.324', 'Merchant Location', 'Merchant Name', true);
INSERT INTO public.merchant VALUES ('3a6ba56f-c50f-4a88-916b-cca61d295dc5', '2024-05-17 03:11:21.494', NULL, '2024-05-17 19:50:34.526', 'Postman', 'Updated Merchant PM 1', false);


--
-- TOC entry 3359 (class 0 OID 16441)
-- Dependencies: 216
-- Data for Name: order_detail; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.order_detail VALUES ('0f2f1897-b657-4292-815c-e91dda92de36', '2024-05-06 20:28:24.189', NULL, '2024-05-06 20:28:24.189', 4, NULL, '981b9196-054e-4caf-ab35-636ff8614af3', '8a841d12-fa96-4128-9429-ecc4cf4a9dab');
INSERT INTO public.order_detail VALUES ('3deffa36-5dbf-4ed1-ac8e-ed1af70b0252', '2024-05-17 20:40:05.144', NULL, '2024-05-17 20:40:05.144', 2, 160000.00, 'a1243ab8-2d6b-48ed-a484-3ef3cb3e3f84', '5a0ab86f-c636-48ab-9963-1476da9e3352');


--
-- TOC entry 3362 (class 0 OID 16468)
-- Dependencies: 219
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.orders VALUES ('981b9196-054e-4caf-ab35-636ff8614af3', '2024-05-06 20:28:24.157', NULL, '2024-05-06 20:28:24.157', false, 'Suka1', '2024-05-06 20:28:24.132', '84f8f2c5-dd6a-4865-8cac-d33de1333506');
INSERT INTO public.orders VALUES ('ff985e73-ed0a-4c25-9f97-37884e9b70a9', '2024-05-17 20:22:29.538', NULL, '2024-05-17 20:22:29.538', false, 'Destination Postman 1', '2024-05-17 20:22:29.498', 'c498dd02-fce9-4d62-9670-a86bb33cc0a4');
INSERT INTO public.orders VALUES ('a0d2669a-405c-4fdd-8f16-4cee08d6276b', '2024-05-17 20:23:49.148', NULL, '2024-05-17 20:23:49.148', false, 'Destination Postman 1', '2024-05-17 20:23:49.13', 'c498dd02-fce9-4d62-9670-a86bb33cc0a4');
INSERT INTO public.orders VALUES ('3ef64afa-fa1d-4e88-90a6-393c9d04654a', '2024-05-17 20:30:10.463', NULL, '2024-05-17 20:30:10.463', false, 'Destination Postman 1', '2024-05-17 20:30:10.431', 'c498dd02-fce9-4d62-9670-a86bb33cc0a4');
INSERT INTO public.orders VALUES ('dd40a720-5a21-4cff-8c69-a23d653a241b', '2024-05-17 20:31:56.169', NULL, '2024-05-17 20:31:56.169', false, 'Destination Postman 1', '2024-05-17 20:31:56.13', 'c498dd02-fce9-4d62-9670-a86bb33cc0a4');
INSERT INTO public.orders VALUES ('4905aef8-64ee-49d0-80a7-4329a6161c24', '2024-05-17 20:33:56.086', NULL, '2024-05-17 20:33:56.086', false, 'Destination Postman 1', '2024-05-17 20:33:56.046', 'c498dd02-fce9-4d62-9670-a86bb33cc0a4');
INSERT INTO public.orders VALUES ('5171a63b-7931-44c4-90ce-61e7e344dd6c', '2024-05-17 20:36:04.245', NULL, '2024-05-17 20:36:04.245', false, 'Destination Postman 1', '2024-05-17 20:36:04.212', 'c498dd02-fce9-4d62-9670-a86bb33cc0a4');
INSERT INTO public.orders VALUES ('a1243ab8-2d6b-48ed-a484-3ef3cb3e3f84', '2024-05-17 20:40:05.119', NULL, '2024-05-17 20:40:05.119', false, 'Destination Postman 1', '2024-05-17 20:40:05', 'c498dd02-fce9-4d62-9670-a86bb33cc0a4');


--
-- TOC entry 3360 (class 0 OID 16446)
-- Dependencies: 217
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.product VALUES ('8a841d12-fa96-4128-9429-ecc4cf4a9dab', '2024-05-05 23:58:31.584', NULL, '2024-05-05 23:58:31.584', 70000, 'Beras', '9d715b02-a53b-4b4d-81fd-83d1f3696c8c');
INSERT INTO public.product VALUES ('8f4c9981-bb31-43c2-9ddf-11f0104152b5', '2024-05-06 23:54:53.3', NULL, '2024-05-06 23:54:53.3', 15000, 'Ayam', '59becb29-7809-46f7-8b3e-6e73582e8962');
INSERT INTO public.product VALUES ('23d78ea8-389a-4f64-a375-9ed7a90b86ba', '2024-05-06 23:55:08.425', NULL, '2024-05-06 23:55:08.425', 17000, 'Ayam', '59becb29-7809-46f7-8b3e-6e73582e8962');
INSERT INTO public.product VALUES ('dd9602b0-4af9-4c48-b346-f1bca9edceee', '2024-05-06 23:55:27.602', NULL, '2024-05-06 23:55:27.602', 12000, 'Ayam', '59becb29-7809-46f7-8b3e-6e73582e8962');
INSERT INTO public.product VALUES ('475be6cc-6ce6-4b8f-a657-e38596d9f961', '2024-05-17 03:11:51.843', '2024-05-17 03:23:18.947', '2024-05-17 03:23:18.947', 40000, 'Test Product Postman Upate 1', '3a6ba56f-c50f-4a88-916b-cca61d295dc5');
INSERT INTO public.product VALUES ('5a0ab86f-c636-48ab-9963-1476da9e3352', '2024-05-17 16:19:41.733', NULL, '2024-05-17 16:19:41.733', 80000, 'Test Product Postman 2', '3a6ba56f-c50f-4a88-916b-cca61d295dc5');


--
-- TOC entry 3361 (class 0 OID 16451)
-- Dependencies: 218
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.users VALUES ('438eecb2-f87a-4bb4-9540-cedd881d5922', '2024-05-05 20:09:20.888919', NULL, '2024-05-05 20:09:20.888919', 'test@gmail.com', 'pwtest', 'test');
INSERT INTO public.users VALUES ('41ae22d7-59f5-4f84-af44-5f96eafdae70', '2024-05-05 20:18:33.714969', NULL, '2024-05-05 20:18:33.714969', 'panji2@gmail.com', 'pwpanji2', 'panji2');
INSERT INTO public.users VALUES ('92f94406-d215-4423-b324-ccd321b1dcd3', '2024-05-05 20:22:07.503974', NULL, '2024-05-05 20:22:07.503974', 'utama@gmail.com', 'pwutama', 'utama');
INSERT INTO public.users VALUES ('84f8f2c5-dd6a-4865-8cac-d33de1333506', '2024-05-05 20:26:07.430442', NULL, '2024-05-05 20:26:07.430442', 'a@gmail.com', 'pwalpha', 'alpha');
INSERT INTO public.users VALUES ('ec91ae06-46ff-4325-9c11-76156398000b', '2024-05-05 20:16:31.082635', NULL, '2024-05-05 20:16:31.082635', 'loki@gmail.com', 'pwloki', 'loki');
INSERT INTO public.users VALUES ('87ea85ab-496b-46a2-8606-2f2ad2647c16', '2024-05-05 23:20:58.644034', NULL, '2024-05-05 23:20:58.644034', 'titut@gmail.com', 'pwtitut', 'titut');
INSERT INTO public.users VALUES ('d97d8b18-3d74-4bab-a6e5-91fe8dd0b9be', '2024-05-06 00:38:23.101741', NULL, '2024-05-06 00:38:23.101741', 'panji1@gmail.com', 'panji1', 'panji');
INSERT INTO public.users VALUES ('27d0bfc1-eabf-45d1-ae4c-3329ff5b7a57', '2024-05-06 00:38:32.893046', NULL, '2024-05-06 00:38:32.893046', 'panji2@gmail.com', 'panji2', 'panji');
INSERT INTO public.users VALUES ('fe2307ec-c182-4804-bb5a-49f930b5edbf', '2024-05-06 00:38:45.255068', NULL, '2024-05-06 00:38:45.255068', 'panji3', 'panji3', 'panji');
INSERT INTO public.users VALUES ('0f85f062-3c60-4c3f-ad2e-bb82564bfcc0', '2024-05-06 19:24:01.785028', NULL, '2024-05-06 19:24:01.785028', 'yey@gmail.com', 'yey', 'yey');
INSERT INTO public.users VALUES ('d55606ff-1229-41f6-95a7-010b63efdb25', '2024-05-06 23:52:15.792993', NULL, '2024-05-06 23:52:15.792993', 'fires@gmail.com', 'fires1224', 'fires1224');
INSERT INTO public.users VALUES ('c498dd02-fce9-4d62-9670-a86bb33cc0a4', '2024-05-17 03:29:39.019', NULL, '2024-05-17 19:55:47.562', 'postman1@google.com', 'postman1@', 'User Postman 1');


--
-- TOC entry 3203 (class 2606 OID 16440)
-- Name: merchant merchant_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.merchant
    ADD CONSTRAINT merchant_pkey PRIMARY KEY (id);


--
-- TOC entry 3205 (class 2606 OID 16445)
-- Name: order_detail order_detail_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.order_detail
    ADD CONSTRAINT order_detail_pkey PRIMARY KEY (id);


--
-- TOC entry 3211 (class 2606 OID 16472)
-- Name: orders orders_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);


--
-- TOC entry 3207 (class 2606 OID 16450)
-- Name: product product_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);


--
-- TOC entry 3209 (class 2606 OID 16457)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 3215 (class 2606 OID 16478)
-- Name: orders fk32ql8ubntj5uh44ph9659tiih; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT fk32ql8ubntj5uh44ph9659tiih FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 3212 (class 2606 OID 16458)
-- Name: order_detail fkb8bg2bkty0oksa3wiq5mp5qnc; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.order_detail
    ADD CONSTRAINT fkb8bg2bkty0oksa3wiq5mp5qnc FOREIGN KEY (product_id) REFERENCES public.product(id);


--
-- TOC entry 3214 (class 2606 OID 16463)
-- Name: product fkk47qmalv2pg906heielteubu7; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT fkk47qmalv2pg906heielteubu7 FOREIGN KEY (merchant_id) REFERENCES public.merchant(id);


--
-- TOC entry 3213 (class 2606 OID 16473)
-- Name: order_detail fkrws2q0si6oyd6il8gqe2aennc; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.order_detail
    ADD CONSTRAINT fkrws2q0si6oyd6il8gqe2aennc FOREIGN KEY (order_id) REFERENCES public.orders(id);


-- Completed on 2024-05-17 21:42:17

--
-- PostgreSQL database dump complete
--

