-- Insert fake stores once :
INSERT INTO public.stores (id,store_code,store_name) VALUES (1, 'A101','Fake-Store')
ON CONFLICT (id) DO NOTHING;

INSERT INTO public.stores (id,store_code,store_name) VALUES (2, 'Admin','For-Admin')
ON CONFLICT (id) DO NOTHING;

INSERT INTO public.stores (id,store_code,store_name) VALUES (3, 'FUDHS','For-User-Doesnt-Have-Store')
ON CONFLICT (id) DO NOTHING;

ALTER SEQUENCE stores_id_seq RESTART WITH 100;

-- Insert fake users once :

INSERT INTO public.users (id,is_active,is_admin,is_bbd_tracker,"password",user_name,store_id) VALUES
	 (1,true,true,false,'$2a$10$fmPQEeDxsvVkRLhdQ52LsupvFIXrBTfCBtVLYEky06SLh5JnMMaQG','1000',2) -- password : admin
ON CONFLICT (id) DO NOTHING;

INSERT INTO public.users (id,is_active,is_admin,is_bbd_tracker,"password",user_name,store_id) VALUES
	 (2,true,false,true,'$2a$10$TljVgwz3qk/cgndH.MvdYe.1Georb9w.H2YGfEDR3hP2375/1Um.e','1001',1)  -- password : bbdTracker
ON CONFLICT (id) DO NOTHING;

INSERT INTO public.users (id,is_active,is_admin,is_bbd_tracker,"password",user_name,store_id) VALUES
	 (3,true,false,false,'$2a$10$u7ypk2vpUFtCJGBVeowXoudTsG0eW.oqo3tD99UVAlJSMpqTELRzq','1002',1) -- password : user
ON CONFLICT (id) DO NOTHING;

ALTER SEQUENCE users_id_seq RESTART WITH 100;