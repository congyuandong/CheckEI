package GetEINum;

public class ResponseMobile {
	
	public String ResByWord1(String searchWord1){
		String jsonStr = "";
		SearchEI sei = new SearchEI();
		JsonFormat js = new JsonFormat();
		String htmlText = sei.SearchBySearchWord1(searchWord1);
		System.out.println(htmlText);
		if(!htmlText.equals("SORRY"))
			jsonStr = js.formatHtml(htmlText);
		else
			return "{\"message\":\"SORRY\"}";
		return jsonStr;
	}
}
