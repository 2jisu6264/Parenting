package reply.service;

import reply.model.ReplyBean;
//import reply.model.ReplyContentBean;

public class ReplyData {

	private ReplyBean Reply;
	//private ReplyContentBean content;

	public ReplyData(ReplyBean Reply) {
		this.Reply = Reply;
		//this.content = content;
	}

	public ReplyBean getReply() {
		return Reply;
	}

	/*public String getContent() {
		return content.getContent();
	}*/

}
