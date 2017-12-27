package com.publiciteweb.webcrawler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Stewart
{
	private boolean onSpecificPattern = true;
	private String root, regularExpression;
	private boolean toScrap = false;

	public Stewart()
	{}

	public Stewart( String root, String pattern )
	{
		this.regularExpression = pattern;
		this.root = root;
	}

	protected boolean basicValidationURL( String href )
	{
		if ( validateNullValue( href ) )
		{
			return false;
		}

		if ( !validateExtension( href ) )
		{
			return false;
		}

		if ( !validateSpecialChar( href ) )
		{
			return false;
		}

		if ( !href.contains( root ) )
		{
			return false;
		}

		return true;
	}

	public boolean isValidPattern( String href )
	{
		Pattern pattern = Pattern.compile( regularExpression );
		Matcher matcher = pattern.matcher( href );
		return matcher.matches();
	}

	public boolean validateURL( String href )
	{
		return basicValidationURL( href ) && !isMailToLink( href );
	}

	public boolean validateNullValue( String string )
	{
		return string == null;
	}

	public boolean validateSpecialChar( String string )
	{
		if ( ( string.indexOf( "{" ) >= 0 ) || ( string.indexOf( "}" ) >= 0 ) || ( string.indexOf( "%space%" ) >= 0 ) )
		{
			return false;
		}
		return true;
	}

	public boolean validateAdressParameter( String string )
	{
		if ( string.indexOf( "?" ) >= 0 )
		{
			return true;
		}
		return false;
	}

	public boolean validateExtension( String string )
	{
		if ( string.indexOf( ".css" ) >= 0 )
		{
			return false;
		}
		if ( string.indexOf( ".ico" ) >= 0 )
		{
			return false;
		}
		if ( string.indexOf( ".pdf" ) >= 0 )
		{
			return false;
		}
		if ( string.indexOf( "javascript" ) >= 0 )
		{
			return false;
		}
		if ( string.indexOf( "#" ) >= 0 )
		{
			return false;
		}
		return true;
	}

	public boolean isMailToLink( String href )
	{
		return href.contains( "mailto" );
	}

	public boolean isOnSpecificPattern()
	{
		return onSpecificPattern;
	}

	public void setOnSpecificPattern( boolean onSpecificPattern )
	{
		this.onSpecificPattern = onSpecificPattern;
	}

	public String getRoot()
	{
		return root;
	}

	public void setRoot( String root )
	{
		this.root = root;
	}

	public String getRegularExpression()
	{
		return regularExpression;
	}

	public void setRegularExpression( String pattern )
	{
		this.regularExpression = pattern;
	}

	public boolean isToScrap()
	{
		return toScrap;
	}

	public void setToScrap( boolean toScrap )
	{
		this.toScrap = toScrap;
	}

	public String toString()
	{
		return root;
	}

}
