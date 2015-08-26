<#macro returnContent content>
${content?replace('щ','&lt;')?replace('Ψ','&gt;')}
</#macro>