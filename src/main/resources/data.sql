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

-- Insert activity types once :

INSERT INTO public.activity_types (id, activity_type) VALUES (1, 'CREATE_BBD_RECORD')
ON CONFLICT (id) DO NOTHING;

INSERT INTO public.activity_types (id, activity_type) VALUES (2, 'REMOVAL_TYPE_GIVE')
ON CONFLICT (id) DO NOTHING;

INSERT INTO public.activity_types (id, activity_type) VALUES (3, 'UPDATE_BBD_RECORD')
ON CONFLICT (id) DO NOTHING;

INSERT INTO public.activity_types (id, activity_type) VALUES (4, 'REMOVAL_TYPE_SALE')
ON CONFLICT (id) DO NOTHING;

INSERT INTO public.activity_types (id, activity_type) VALUES (5, 'DELETE_BBD_RECORD')
ON CONFLICT (id) DO NOTHING;

INSERT INTO public.activity_types (id, activity_type) VALUES (6, 'CHECK_BBD_PAST_PRODUCT_DONT_EXIST')
ON CONFLICT (id) DO NOTHING;

INSERT INTO public.activity_types (id, activity_type) VALUES (7, 'CHECK_BBD_PAST_PRODUCT_REMOVED')
ON CONFLICT (id) DO NOTHING;

INSERT INTO public.activity_types (id, activity_type) VALUES (8, 'USER_CHANGE_PASSWORD')
ON CONFLICT (id) DO NOTHING;

INSERT INTO public.activity_types (id, activity_type) VALUES (9, 'ADD_USER_BY_BBD_TRACKER')
ON CONFLICT (id) DO NOTHING;

INSERT INTO public.activity_types (id, activity_type) VALUES (10, 'ADD_STORE_TO_USER_BY_BBD_TRACKER')
ON CONFLICT (id) DO NOTHING;

INSERT INTO public.activity_types (id, activity_type) VALUES (11, 'REMOVE_USER_FROM_STORE_BY_BBD_TRACKER')
ON CONFLICT (id) DO NOTHING;

INSERT INTO public.activity_types (id, activity_type) VALUES (12, 'ADD_PRODUCT_BY_BBD_TRACKER')
ON CONFLICT (id) DO NOTHING;

INSERT INTO public.activity_types (id, activity_type) VALUES (13, 'CREATE_STORE_BY_ADMIN')
ON CONFLICT (id) DO NOTHING;

ALTER SEQUENCE activity_types_id_seq RESTART WITH 100;

-- Insert bbd trackers once :

INSERT INTO public.bbd_trackers (id, note_for_tracker, user_id) VALUES (1, null, 2)
ON CONFLICT (id) DO NOTHING;

ALTER SEQUENCE bbd_trackers_id_seq RESTART WITH 100;