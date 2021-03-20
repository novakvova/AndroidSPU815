using Food.Domain;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Identity.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Text;

namespace Food.EFData
{
    public class DataContext : IdentityDbContext<AppUser, AppRole, long, IdentityUserClaim<long>,
                    AppUserRole, IdentityUserLogin<long>,
                    IdentityRoleClaim<long>, IdentityUserToken<long>>
    {
        public DataContext(DbContextOptions<DataContext> options)
            : base(options)
        {

        }
    }
}
