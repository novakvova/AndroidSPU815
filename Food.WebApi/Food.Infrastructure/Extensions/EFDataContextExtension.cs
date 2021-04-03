using Food.Application.Constants;
using Food.Domain;
using Food.EFData;
using Microsoft.AspNetCore.Identity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Food.Infrastructure.Extensions
{
    public static class EFDataContextExtension
    {
        public static void EnsureSeeder(this DataContext context, 
            UserManager<AppUser> userManager, RoleManager<AppRole> roleManager)
        {
            CreateDefaultRoles(roleManager);
        }
        private static void CreateDefaultRoles(RoleManager<AppRole> roleManager)
        {
            if(!roleManager.Roles.Any())
            {
                var result = roleManager.CreateAsync(new AppRole
                {
                    Name = Roles.Admin
                }).Result;
                if(!result.Succeeded)
                {
                    throw new ApplicationException($"Defalut role `{Roles.Admin}` cannot be created");
                }
            }
        }
    }
}
