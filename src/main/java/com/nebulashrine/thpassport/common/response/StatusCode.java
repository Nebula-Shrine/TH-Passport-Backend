package com.nebulashrine.thpassport.common.response;

public enum StatusCode {

     SUCCESS(10201, "请求成功"),
     FAILED(10501, "请求失败");

     private final int statusCode;

     private final String resultMessage;

     StatusCode(int statusCode, String resultMessage){
          this.resultMessage = resultMessage;
          this.statusCode = statusCode;
     };

     public int getStatusCode() {
          return statusCode;
     }

     public String getResultMessage() {
          return resultMessage;
     }
}
