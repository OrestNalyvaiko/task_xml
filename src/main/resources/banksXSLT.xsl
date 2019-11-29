<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
    <html>
      <body>
        <table border="1">
          <tr bgcolor="#9acd32">
            <th style="width:250px">name</th>
            <th style="width:350px">country</th>
            <th style="width:250px">type</th>
            <th style="width:250px">depositor</th>
            <th style="width:250px">accountID</th>
            <th style="width:250px">amountOnDeposit</th>
            <th style="width:250px">profitability</th>
            <th style="width:250px">timeConstraints</th>
          </tr>

          <xsl:for-each select="banks/bank">
            <tr>
              <td>
                <xsl:value-of select="name"/>
              </td>
              <td>
                <xsl:value-of select="country"/>
              </td>

              <td>
                <xsl:value-of select="type"/>
              </td>
              <td>
                <xsl:value-of select="depositor"/>
              </td>

              <td>
                <xsl:value-of select="accountID"/>
              </td>

              <td>
                <xsl:value-of select="amountOnDeposit"/>
              </td>

              <td>
                <xsl:value-of select="profitability"/>
              </td>

              <td>
                <xsl:value-of select="timeConstraints"/>
              </td>
            </tr>

          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>