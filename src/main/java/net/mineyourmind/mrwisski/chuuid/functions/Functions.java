package net.mineyourmind.mrwisski.chuuid.functions;

import java.util.UUID;

import net.kaikk.mc.uuidprovider.UUIDProvider;
import net.mineyourmind.mrwisski.chuuid.CHUUID;

import com.laytonsmith.PureUtilities.Version;
import com.laytonsmith.annotations.api;
import com.laytonsmith.core.CHVersion;
import com.laytonsmith.core.constructs.CString;
import com.laytonsmith.core.constructs.Construct;
import com.laytonsmith.core.constructs.Target;
import com.laytonsmith.core.environments.CommandHelperEnvironment;
import com.laytonsmith.core.environments.Environment;
import com.laytonsmith.core.exceptions.ConfigRuntimeException;
import com.laytonsmith.core.functions.AbstractFunction;
import com.laytonsmith.core.functions.Exceptions.ExceptionType;

public class Functions {
	
    public static String docs() {
        return "Nothing to see here...";
    }
 
    @api(environments = {CommandHelperEnvironment.class})
    public static class get_name extends AbstractFunction {

		@Override
		public Construct exec(Target arg0, Environment arg1, Construct... arg2)
				throws ConfigRuntimeException {
			if(CHUUID.instance.uuidprov != null && CHUUID.instance.enabled){
				UUID uuid = UUID.fromString(arg2[0].getValue());
				String name = UUIDProvider.retrieve(uuid);
				return new CString(name,arg0);
			} else {
				return null;
			}
		}

		@Override
		public boolean isRestricted() {
			return true;
		}

		@Override
		public Boolean runAsync() {
			return false;
		}

		@Override
		public ExceptionType[] thrown() {
			
			return null;
		}

		@Override
		public String docs() {
			
			return null;
		}

		public String getName() {
			
			return "get_name";
		}

		public Integer[] numArgs() {
			return new Integer[]{1};
		}

		public Version since() {
			
			return CHVersion.V3_3_1;
		}

    }
    
    @api(environments = {CommandHelperEnvironment.class})
    public static class get_uuid extends AbstractFunction {

		public Construct exec(Target arg0, Environment arg1, Construct... arg2) throws ConfigRuntimeException {
//			MCPlayer p = arg1.getEnv(CommandHelperEnvironment.class).GetPlayer();

			if(CHUUID.instance.uuidprov != null && CHUUID.instance.enabled){
				UUID uuid = UUIDProvider.retrieve(arg2[0].getValue());
				return new CString(uuid.toString(),arg0);
			} else {
				return null;
			}
		}

		public boolean isRestricted() {
			
			return true;
		}

		public Boolean runAsync() {
			
			return false;
		}

		public ExceptionType[] thrown() {
			
			return null;
		}

		public String docs() {
			
			return null;
		}

		public String getName() {
			
			return "get_uuid";
		}

		public Integer[] numArgs() {
			return new Integer[]{1};
		}

		public Version since() {
			return CHVersion.V3_3_1;
		}
      
    }	
}
