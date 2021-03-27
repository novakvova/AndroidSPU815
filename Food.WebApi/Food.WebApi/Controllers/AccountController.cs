using Food.Application.Account;
using Food.Application.Account.Login;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Food.WebApi.Controllers
{
    [AllowAnonymous]
    public class AccountController : BaseController
    {
        [HttpPost("login")]
        public async Task<ActionResult<UserViewModel>> LoginAsync(LoginQuery query)
        {
            return await Mediator.Send(query);
        }
    }
}
