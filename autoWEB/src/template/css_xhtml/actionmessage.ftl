<#--
/*
 * $Id: actionmessage.ftl 805635 2009-08-19 00:18:54Z musachy $
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
-->
<#if (actionMessages?? && actionMessages?size > 0 && !parameters.isEmptyList)>
	<div align="center" class="topSpace" style="width: 100%;">
	<div id="infoMessage" class="ui-widget" align="left">
		<div class="ui-state-highlight ui-corner-all" style="padding: 0pt 0.7em;">
			<p><span class="ui-icon ui-icon-info" style="float: left; margin-right: 0.3em;"></span>
			<strong>Informaci&oacute;n:</strong>
	<ul<#rt/>
<#if parameters.id?if_exists != "">
 id="${parameters.id?html}"<#rt/>
</#if>
<#if parameters.cssClass??>
 class="${parameters.cssClass?html}"<#rt/>
<#else>
 class="actionMessage"<#rt/>
</#if>
<#if parameters.cssStyle??>
 style="${parameters.cssStyle?html}"<#rt/>
</#if>
>
		<#list actionMessages as message>
            <#if message?if_exists != "">
                <li><span><#if parameters.escape>${message!?html}<#else>${message!}</#if></span></li>
            </#if>
		</#list>
	</ul>
			</p>
		</div>
	</div>
	</div>
</#if>