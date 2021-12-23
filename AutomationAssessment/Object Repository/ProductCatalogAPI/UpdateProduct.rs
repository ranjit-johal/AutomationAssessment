<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>UpdateProduct</name>
   <tag></tag>
   <elementGuidId>86c0426f-dfd4-4b02-8b58-67217e0c6f99</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;id\&quot;: \&quot;${id}\&quot;,\n  \&quot;name\&quot;: \&quot;${name}\&quot;,\n  \&quot;description\&quot;: \&quot;${description}\&quot;,\n  \&quot;price\&quot;: ${price},\n  \&quot;itemCount\&quot;: ${itemCount},\n  \&quot;isActive\&quot;: ${isActive},\n  \&quot;createdDateTime\&quot;: \&quot;${createdDateTime}\&quot;,\n  \&quot;modifiedDateTime\&quot;: \&quot;${modifiedDateTime}\&quot;\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Accept</name>
      <type>Main</type>
      <value>application/json</value>
   </httpHeaderProperties>
   <katalonVersion>8.0.5</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>PUT</restRequestMethod>
   <restUrl>https://qarecruitment.azurewebsites.net/v1/product/${id}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>GlobalVariable.productId</defaultValue>
      <description></description>
      <id>45d7e1d2-8d29-4d82-833e-a77b67c23a2f</id>
      <masked>false</masked>
      <name>id</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.productName</defaultValue>
      <description></description>
      <id>a691341a-9dab-46d6-8a5a-079a3c900e17</id>
      <masked>false</masked>
      <name>name</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.productDescription</defaultValue>
      <description></description>
      <id>aeefba95-4355-4d9f-81bb-02fa89a4e7bf</id>
      <masked>false</masked>
      <name>description</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.productPrice</defaultValue>
      <description></description>
      <id>4f0e2008-9a7d-4492-94bd-34db1aed324e</id>
      <masked>false</masked>
      <name>price</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.productQuantity</defaultValue>
      <description></description>
      <id>5687be3b-d316-4d22-b49f-c7cc37cf9578</id>
      <masked>false</masked>
      <name>itemCount</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.isProductActive</defaultValue>
      <description></description>
      <id>afa2035f-e061-4603-acd9-0274affb93d2</id>
      <masked>false</masked>
      <name>isActive</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.productCreateDateTime</defaultValue>
      <description></description>
      <id>53a15ca3-b574-4321-ab84-41be205d3866</id>
      <masked>false</masked>
      <name>createdDateTime</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.productModifiedDateTime</defaultValue>
      <description></description>
      <id>4d1dcc27-444e-440f-8eb0-9fb7ae183100</id>
      <masked>false</masked>
      <name>modifiedDateTime</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
