INSERT INTO public.users (is_active,is_admin,is_bbd_tracker,"password",user_name,store_id) VALUES
	 (true,true,false,'$2a$10$fmPQEeDxsvVkRLhdQ52LsupvFIXrBTfCBtVLYEky06SLh5JnMMaQG','1000',2),  -- password : admin
	 (true,false,true,'$2a$10$TljVgwz3qk/cgndH.MvdYe.1Georb9w.H2YGfEDR3hP2375/1Um.e','1001',1),  -- password : bbdTracker
	 (true,false,false,'$2a$10$u7ypk2vpUFtCJGBVeowXoudTsG0eW.oqo3tD99UVAlJSMpqTELRzq','1002',1); -- password : user
