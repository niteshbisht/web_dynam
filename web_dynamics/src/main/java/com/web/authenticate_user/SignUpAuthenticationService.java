package com.web.authenticate_user;

public class SignUpAuthenticationService {
	private String userId;
	private String passWord;
//	private final long uniqueUuid;
	private GenerateUUid uuid;
	private static SignUpAuthenticationService INSTANCE = null;
	private SignUpAuthenticationService(String userId, String passWord) {
		this.userId = userId;
		this.passWord = passWord;
		uuid=new GenerateUUid();
		ElastDbUserSignStore.addUserID(uuid.uniqueUuidHash, userId, passWord);
	}
	
	private class GenerateUUid{
		private long uniqueUuidHash;
		public GenerateUUid() {
			uniqueUuidHash = userId.hashCode()+passWord.hashCode();
		}
	}

	public static SignUpAuthenticationService getAuthenticated(String userId, String passWord){
		if(INSTANCE==null)
			INSTANCE = new SignUpAuthenticationService(userId, passWord);
		else
			return INSTANCE;		
		return INSTANCE;
	}
}
