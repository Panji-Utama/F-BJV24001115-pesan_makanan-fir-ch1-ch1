--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

-- Started on 2024-05-06 01:29:10

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


--
-- TOC entry 3359 (class 0 OID 16441)
-- Dependencies: 216
-- Data for Name: order_detail; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 3362 (class 0 OID 16468)
-- Dependencies: 219
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 3360 (class 0 OID 16446)
-- Dependencies: 217
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.product VALUES ('8a841d12-fa96-4128-9429-ecc4cf4a9dab', '2024-05-05 23:58:31.584', NULL, '2024-05-05 23:58:31.584', 70000, 'Beras', '9d715b02-a53b-4b4d-81fd-83d1f3696c8c');


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


-- Completed on 2024-05-06 01:29:10

--
-- PostgreSQL database dump complete
--

