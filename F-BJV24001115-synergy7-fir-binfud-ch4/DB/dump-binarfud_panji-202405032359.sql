--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

-- Started on 2024-05-03 23:59:00

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
-- TOC entry 3366 (class 1262 OID 16401)
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
-- TOC entry 3367 (class 0 OID 0)
-- Dependencies: 5
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- TOC entry 220 (class 1255 OID 16497)
-- Name: register_user(character varying, character varying, character varying); Type: FUNCTION; Schema: public; Owner: -
--

CREATE FUNCTION public.register_user(username character varying, email character varying, password character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$
BEGIN
    INSERT INTO users (id, username, email_address, password, created_date, updated_date)
    VALUES (uuid_generate_v4(), username, email, password, NOW(), NOW());
END;
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
-- TOC entry 3356 (class 0 OID 16434)
-- Dependencies: 215
-- Data for Name: merchant; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.merchant VALUES ('9d715b02-a53b-4b4d-81fd-83d1f3696c8c', '2024-05-03 19:50:48.796', NULL, '2024-05-03 19:50:48.796', 'Jakarta', 'Test Merchant', true);
INSERT INTO public.merchant VALUES ('59becb29-7809-46f7-8b3e-6e73582e8962', '2024-05-03 19:46:12.188', NULL, '2024-05-03 19:51:27.953', 'Bandung', 'Warung Ayam', false);


--
-- TOC entry 3357 (class 0 OID 16441)
-- Dependencies: 216
-- Data for Name: order_detail; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 3360 (class 0 OID 16468)
-- Dependencies: 219
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 3358 (class 0 OID 16446)
-- Dependencies: 217
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.product VALUES ('2d0380f7-cb5d-402b-8ccf-f4c1cec96806', '2024-05-03 23:43:31.407', NULL, '2024-05-03 23:43:31.407', 20000, 'Ayam', NULL);


--
-- TOC entry 3359 (class 0 OID 16451)
-- Dependencies: 218
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.users VALUES ('1634c3b1-1dae-4417-876c-affea0e35be8', '2024-05-03 19:26:52.716', NULL, '2024-05-03 19:26:52.716', 'panji@gmail.com', 'panji123', 'panji');
INSERT INTO public.users VALUES ('921933b0-e58c-40a3-8af4-3299b393512b', '2024-05-03 19:49:43.993', NULL, '2024-05-03 19:49:43.993', 'test@gmail.com', 'test123', 'test');
INSERT INTO public.users VALUES ('bec5789f-53bb-4223-bee6-cfc3b9ae5bbc', '2024-05-03 20:25:10.584397', NULL, '2024-05-03 20:25:10.584397', 'newuser@example.com', 'password123', 'newuser');
INSERT INTO public.users VALUES ('cb5af216-3693-44ba-86cb-482dd57a383c', '2024-05-03 20:26:20.856242', NULL, '2024-05-03 20:26:20.856242', 'newuser1@example.com', 'password123', 'newuser1');
INSERT INTO public.users VALUES ('9e65437e-c456-43ef-b620-08f81623b70c', '2024-05-03 20:26:23.935426', NULL, '2024-05-03 20:26:23.935426', 'newuser1@example.com', 'password123', 'newuser1');
INSERT INTO public.users VALUES ('8a6f3bfc-3a52-4ae5-9749-b4f45c9379a9', '2024-05-03 20:26:25.499846', NULL, '2024-05-03 20:26:25.499846', 'newuser1@example.com', 'password123', 'newuser1');
INSERT INTO public.users VALUES ('c2d15bc7-bbca-4d98-8194-a9ad3d9912d0', '2024-05-03 23:37:30.644', NULL, '2024-05-03 23:37:30.644', 'pertama@gmail.com', 'pertama123', 'pertama');


--
-- TOC entry 3201 (class 2606 OID 16440)
-- Name: merchant merchant_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.merchant
    ADD CONSTRAINT merchant_pkey PRIMARY KEY (id);


--
-- TOC entry 3203 (class 2606 OID 16445)
-- Name: order_detail order_detail_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.order_detail
    ADD CONSTRAINT order_detail_pkey PRIMARY KEY (id);


--
-- TOC entry 3209 (class 2606 OID 16472)
-- Name: orders orders_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);


--
-- TOC entry 3205 (class 2606 OID 16450)
-- Name: product product_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);


--
-- TOC entry 3207 (class 2606 OID 16457)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 3213 (class 2606 OID 16478)
-- Name: orders fk32ql8ubntj5uh44ph9659tiih; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT fk32ql8ubntj5uh44ph9659tiih FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 3210 (class 2606 OID 16458)
-- Name: order_detail fkb8bg2bkty0oksa3wiq5mp5qnc; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.order_detail
    ADD CONSTRAINT fkb8bg2bkty0oksa3wiq5mp5qnc FOREIGN KEY (product_id) REFERENCES public.product(id);


--
-- TOC entry 3212 (class 2606 OID 16463)
-- Name: product fkk47qmalv2pg906heielteubu7; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT fkk47qmalv2pg906heielteubu7 FOREIGN KEY (merchant_id) REFERENCES public.merchant(id);


--
-- TOC entry 3211 (class 2606 OID 16473)
-- Name: order_detail fkrws2q0si6oyd6il8gqe2aennc; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.order_detail
    ADD CONSTRAINT fkrws2q0si6oyd6il8gqe2aennc FOREIGN KEY (order_id) REFERENCES public.orders(id);


-- Completed on 2024-05-03 23:59:00

--
-- PostgreSQL database dump complete
--

