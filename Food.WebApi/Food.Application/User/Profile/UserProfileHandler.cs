using Food.Application.Account;
using Food.Application.Exceptions;
using MediatR;
using System;
using System.Collections.Generic;
using System.Net;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace Food.Application.User.Profile
{
    public class UserProfileHandler : IRequestHandler<UserProfileCommand, UserViewModel>
    {

        public Task<UserViewModel> Handle(UserProfileCommand request, CancellationToken cancellationToken)
        {

            throw new RestException(HttpStatusCode.NotFound);
        }
    }
}
