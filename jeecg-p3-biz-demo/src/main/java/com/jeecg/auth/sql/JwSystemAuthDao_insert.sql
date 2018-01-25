insert into 
jp_demo_auth
      ( auth_id,auth_name,auth_type,auth_contr,parent_auth_id,leaf_ind) 
values
      (:auth.authId,
       :auth.authName,
   	   :auth.authType,
       :auth.authContr,
	   :auth.parentAuthId,
       :auth.leafInd
      )